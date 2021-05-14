package com.car.oops_20

/*
* In Kotlin, we cannot create an instance of an abstract class.
*
* Abstract class could only be inherited by a class or another Abstract class.
* So, to use abstract class, create another class that inherits the Abstract class.
* */

//its instance cannot be made
abstract class Vehicle {
    var name: String = ""
    var wheels: Int = 0
    var price: Double = 0.0
    abstract fun showDetails() //must be overridden
    open fun showDetails2() {} //may be overridden
    fun showDetails3() {} // cannot be overridden
}

class Bike(name: String, price: Double) : Vehicle() {
    init {
        this.name = "Bike: $name"
        this.price = price
        this.wheels = 2
    }

    override fun showDetails() {
        println("${this.name} ${this.wheels} ${this.price}")
    }

    fun raiseFrontWheel(){
        println("Front wheel raised!")
    }
}

class Car(name: String, price: Double) : Vehicle() {
    init {
        this.name = "Car: $name"
        this.price = price
        this.wheels = 4
    }

    override fun showDetails() {
        println("${this.name} ${this.wheels} ${this.price}")
    }
}

fun updatePrice(vehicle: Vehicle) {
    vehicle.price += 12345
}

fun main() {
    val bike1:Bike = Bike("BIKE1", 20000.0)
    bike1.raiseFrontWheel()
    val car1:Car = Car("CAR1", 100000.0)
    //=====================typecasting==========================
    //bike2 is a Bike object stored in vehicle type reference
    val bike2:Vehicle = Bike("BIKE2", 20000.0)
//    bike2.raiseFrontWheel() // not available
    //bike3 is a typecast of Bike object into vehicle object
    val bike3 = Bike("BIKE3", 20000.0) as Vehicle
    println("=============ARRAY OF VEHICLES===============")
    val vehicles = arrayListOf<Vehicle>()
    vehicles.add(bike1)
    vehicles.add(car1)
    for (v in vehicles) {
        v.showDetails()
        updatePrice(v)
        v.showDetails()
    }
}

/*
* val obj:parent = child() //accepted
* val obj:child = parent() //not accepted
* */