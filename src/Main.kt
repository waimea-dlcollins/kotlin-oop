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

    val room1 = Room("Test Room", 5, 4, 3)
    println("Volume: ${room1.volume()} cubic meters")
    println("Surface Area: (excluding door and window) ${room1.area()} square meters")

    val bedroom = Room("Bedroom", 5, 5, 2 )
    val kitchen = Room("kitchen",2,2,2)
    val door = Door(1.0, 2.0)
    val window = Window(1.5, 1.0)


    val jimmy = Person1("jimmy", 1.95, "teal")
    val dave = Person2("dave", 1.92, "brown")
    val cedric = Person3("cedric", 2.45, "gold")
    val daivd = Person4("david", 5.65, "turquoise")


    jimmy.sayHello()
    jimmy.saycurrentHeight()
    jimmy.saycurrentfavColour()
    jimmy.greet()

    dave.sayHello()
    dave.saycurrentHeight()
    dave.saycurrentfavColour()
    dave.greet()

    cedric.sayHello()
    cedric.saycurrentHeight()
    cedric.saycurrentfavColour()
    cedric.greet()

    daivd.sayHello()
    daivd.saycurrentHeight()
    daivd.saycurrentfavColour()
    daivd.greet()

    room1.assignOwner(jimmy)
    bedroom.assignOwner(jimmy)
    kitchen.assignOwner(jimmy)
    bedroom.printDetails()
    room1.printDetails()
    kitchen.printDetails()



    println("Painting rooms...")
    room1.paint()
    bedroom.paint()
    kitchen.paint()

    val tinCoverage = 10.0
    println("Tins needed for each room:")
    println("---------------------------------------------------")
    println("${room1.name} needs ${room1.tinsNeeded(tinCoverage)} tins of paint.")
    println("---------------------------------------------------")
    println("${bedroom.name} needs ${bedroom.tinsNeeded(tinCoverage)} tins of paint.")
    println("${kitchen.name} needs ${bedroom.tinsNeeded(tinCoverage)} tins of paint.")

    println("Room details after assigning owners:")
    room1.info()
    bedroom.info()
    kitchen.info()
    door.area()
    window.area()
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
    var door: Door? = null
    var window: Window? = null

    var owner: Person1? = null
    var color : String = "unpainted"

    fun assignOwner(newOwner: Person1) {
        owner = newOwner

    }

    fun printDetails() {

        println("${name} is owned by ${owner?.name ?: "no owner"}")
        println("---------------------------------------------------")
    }

    fun volume(): Int {

        return depth * width * height
    }

    fun area(): Int {
        val wallArea = 2 * (depth * height + width * height)
        return wallArea


    }
    fun paint() {
        if (owner != null) {
            color = owner!!.favColour

            println("$name has been painted $color by it's owner ${owner!!.name}.")
            println("---------------------------------------------------")

        } else {
            println("$name cannot be painted because it has no owner")
            println("---------------------------------------------------")
        }
    }

    fun tinsNeeded(tinCoverage: Double): Double{
        val roomArea = area()
        val tinsRequired = roomArea / tinCoverage

        return tinsRequired
    }

    fun info() {

        println("Room Name: $name")
        println("---------------------------------------------------")
        println("Volume: ${volume()} cubic meters")
        println("---------------------------------------------------")
        println("Surface Area: (excluding door & window) ${area()} square meters")
        println("---------------------------------------------------")
        println("Owner: ${owner?.name ?: "No Owner"}")
        println("---------------------------------------------------")
    }


}


class kitchen(val name: String, val depth: Int, val width: Int, val height: Int) {
    var door: Door? = null
    var window: Window? = null

    var owner: Person1? = null
    var color : String = "unpainted"

    fun assignOwner(newOwner: Person1) {
        owner = newOwner

    }

    fun printDetails() {

        println("${name} is owned by ${owner?.name ?: "no owner"}")
        println("---------------------------------------------------")
    }

    fun volume(): Int {

        return depth * width * height
    }

    fun area(): Int {
        val wallArea = 2 * (depth * height + width * height)
        return wallArea


    }
    fun paint() {
        if (owner != null) {
            color = owner!!.favColour

            println("$name has been painted $color by it's owner ${owner!!.name}.")
            println("---------------------------------------------------")

        } else {
            println("$name cannot be painted because it has no owner")
            println("---------------------------------------------------")
        }
    }

    fun tinsNeeded(tinCoverage: Double): Double{
        val roomArea = area()
        val tinsRequired = roomArea / tinCoverage

        return tinsRequired
    }

    fun info() {

        println("Room Name: $name")
        println("---------------------------------------------------")
        println("Volume: ${volume()} cubic meters")
        println("---------------------------------------------------")
        println("Surface Area: (excluding door & window) ${area()} square meters")
        println("---------------------------------------------------")
        println("Owner: ${owner?.name ?: "No Owner"}")
        println("---------------------------------------------------")
    }


}

class Person1(val name: String, var height: Double,  var favColour: String) {
    fun sayHello() {
        println("---------------------------------------------------")
        println("Hello, my name is $name!")
        println("---------------------------------------------------")
    }

    fun saycurrentHeight() {
        println("Hello, my current height is ${height}m")
        println("---------------------------------------------------")
    }

    fun saycurrentfavColour() {
        println("Hello, my fav colour is $favColour")
        println("---------------------------------------------------")
    }

    fun greet() {
        println("Hello my name is $name, i am ${height}m tall and my fav color is $favColour")
        println("---------------------------------------------------")
    }


}
class Door(var width: Double, var height: Double) {
    fun area(): Double {
        return width * height
    }
}

class Window(var width: Double, var height: Double) {
    fun area(): Double {
        return width * height
    }
}
class Person2(val name: String, var height: Double,  var favColour: String) {
    fun sayHello() {
        println("---------------------------------------------------")
        println("Hello, my name is $name!")
        println("---------------------------------------------------")
    }

    fun saycurrentHeight() {
        println("Hello, my current height is ${height}m")
        println("---------------------------------------------------")
    }

    fun saycurrentfavColour() {
        println("Hello, my fav colour is $favColour")
        println("---------------------------------------------------")
    }

    fun greet() {
        println("Hello my name is $name, i am ${height}m tall and my fav color is $favColour")
        println("---------------------------------------------------")


        class Door(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }

        class Window(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }
    }

}
class Person3(val name: String, var height: Double,  var favColour: String) {
    fun sayHello() {
        println("---------------------------------------------------")
        println("Hello, my name is $name!")
        println("---------------------------------------------------")
    }

    fun saycurrentHeight() {
        println("Hello, my current height is ${height}m")
        println("---------------------------------------------------")
    }

    fun saycurrentfavColour() {
        println("Hello, my fav colour is $favColour")
        println("---------------------------------------------------")
    }

    fun greet() {
        println("Hello my name is $name, i am ${height}m tall and my fav color is $favColour")
        println("---------------------------------------------------")

        class Door(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }

        class Window(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }
    }
}
class Person4(val name: String, var height: Double,  var favColour: String) {
    fun sayHello() {
        println("---------------------------------------------------")
        println("Hello, my name is $name!")
        println("---------------------------------------------------")
    }

    fun saycurrentHeight() {
        println("Hello, my current height is ${height}m")
        println("---------------------------------------------------")
    }

    fun saycurrentfavColour() {
        println("Hello, my fav colour is $favColour")
        println("---------------------------------------------------")
    }

    fun greet() {
        println("Hello my name is $name, i am ${height}m tall and my fav color is $favColour")
        println("---------------------------------------------------")
        class Door(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }

        class Window(var width: Double, var height: Double) {
            fun area(): Double {
                return width * height
            }
        }

    }
}







