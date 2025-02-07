import jdk.internal.vm.StackChunk.init

fun main() {
    val cat1 = Cat("Jimmy")
    val cat2 = Cat("Dave")
    val cat3 = Cat("Nigel")
    println(cat1)
    println(cat2)

    cat1.poke()
    cat1.stroke()
    cat1.stroke()
    cat1.poke()

    println(cat1)
    cat1.makeFriends(cat3)
    println(cat1)

}


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
        fun makeFriends (newFriend: Cat) {
            bff = newFriend

            newFriend.bff = this // connect back to us (this)

            println("$name is now friends with ${newFriend.name}")


        }

    }


    class roomVolume(val height: Int,val width: Int, val depth: Int) {
        var roomVolume: Int = 0
        fun volume(): Int {
            var roomVolume: Int = 0
            roomVolume += "height: $height\n"
            roomVolume += "width: $width\n"
            roomVolume += "depth: $depth\n"

            return roomVolume

        }
        //return the volume of the room = h * w * l
        // return volume

    }
    class roomArea(val height: Int, val width: Int) {
        var roomArea: Int = 0
        fun volume(): Int {
            var roomArea: Int = 0
            roomArea += "height: $height\n"
            roomArea += "width: $width\n"


            return roomArea
        }
    }




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





