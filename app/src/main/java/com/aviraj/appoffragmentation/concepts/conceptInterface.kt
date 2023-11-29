package com.aviraj.appoffragmentation.concepts

object conceptInterface {
    @JvmStatic
    fun main(args: Array<String>) {
        val carObj = Car(5)
        carObj.fly()
    }
}



interface Vehicle{
    fun fly() {

    }
    fun move() {

    }
}


class Car(var position: Int): Vehicle {

    override fun move() {
        position += 1
    }

}

class Aeroplane(var position: Int): Vehicle {
    override fun fly() {
        super.fly()
        position += 1
    }
}