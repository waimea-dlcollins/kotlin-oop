/**
 * intro to OOP looking at the creation
 * and use of classes and objects
 */

/**
 * the Main() method is the entry point for any kotlin program
 */
fun main() {
    // let's make some cats
    val cat1 = Cat("Jimmy")
    val cat2 = Cat("Dave")
    val cat3 = Cat("Nigel")

    println(cat1)
    println(cat2)
    println(cat3)

    // play with the cats
    cat1.poke()
    cat1.stroke()
    cat1.stroke()
    cat1.poke()

    // manipulate the cat friendships
    println(cat1)
//    cat1.makeFriends(cat3)
    println(cat1)


   //-------------------------------------------------

    val room = Room("Test Room", 5, 4, 3)
    println("Volume: ${room.volume()} cubic meters")
    println("Surface Area: ${room.area()} square meters")

    val bedroom = Room("Bedroom", 5, 5, 2)
    val kitchen = Room("kitchen",2,2,2)
    val owner: Person? = null

    val jimmy = Person("Jimmy", 1.95, "teal")

    jimmy.sayHello()
    jimmy.saycurrentHeight()
    jimmy.saycurrentfavColour()
    jimmy.greet()
    bedroom.info()
//    kitchen.info()


}


/**
 * Cat class, tracking name and other key data
 * cats can be woken, stroked, make friends, etc.
 */

class Cat(val name: String, var Legs: Int = 4) {
    var isSleeping: Boolean = false;
    var isHungry: Boolean = false;
    var bff: Cat? = null


    fun poke() {

        if (isSleeping) {
            isSleeping = false
            println("you woke up $name!")
        } else {
            println("$name is angry and scratches you")
        }
    }

    fun stroke() {
        println("$name prrrrrrrrrrrr")
        if (!isSleeping) {
            isSleeping = true
            println("$name falls alseep")
        } else {
            println("$name goes to sleep")
        }
        fun makeFriends(newFriend: Cat) {
            bff = newFriend

            newFriend.bff = this // connect back to us (this)

            println("$name is now friends with ${newFriend.name}")


        }

    }

    // this method is run when an object is created
    init {
        println("creating a new cat")
    }

    // this replaces the default function that prints
    // the object's ID with something more useful
    override fun toString(): String {
        var info: String = ""
        info += "Name: $name\n"
        info += "Legs: $Legs\n"
        info += "Hungry: $isHungry\n"
        info += "Sleeping: $isSleeping\n"
        if (bff != null) {
            info += "bff: ${bff!!.name}"
        } else {
            info += "No Bff!"
        }
        info += "bff: $bff!!.name}"

        return info

    }
}






class Room(val name: String, val depth: Int, val width: Int, val height: Int) {

    fun volume(): Int {

        return depth * width * height
    }

    fun area(): Int {
        val wallArea = 2 * (depth * height + width * height)
        return wallArea

    }
}


class Person(val name: String, var height: Double,  var favColour: String) {
    fun sayHello() {
        println("Hello, my name is $name!")
    }
    fun saycurrentHeight() {
        println("Hello, my current height is $height")
    }
    fun saycurrentfavColour() {
        println("Hello, my fav colour is $favColour")
    }
    fun greet() {
        println("Hello my name is $name, i am $height tall and my fav color is $favColour")
    }
    fun setOwner(newOwner: Person) {
        bedroom.setOwner(jimmy)
    }

}








