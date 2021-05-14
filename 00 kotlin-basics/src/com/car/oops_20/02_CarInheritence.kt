package com.car.oops_20

open class RacingCar(name: String, private var power: Double) : CarSimple() {
    protected var power2: Double = power * 2

    init {
        this.name = name
        super.name = name + "SUP"
        println("$name $power")
        println("${this.name} ${this.power}")
        println("${super.name}")
    }

    open fun getPower(): Double {
        return this.power
    }
}

open class FastestRacingCar(name: String, power: Double) : RacingCar(name, power) {
    var speed: Double = 0.0

    init {
//        this.power //even child class cannot access private
        this.power2 = 3 * getPower() //protected is accessed here
        this.speed = 200 + (getPower() / 2)
    }

    final override fun getPower(): Double {
        return this.power2
    }
    fun getSuperPower():Double{
        return super.getPower()
    }
}

class SuperFastestRacingCar(name: String, power: Double) : FastestRacingCar(name, power) {
    init {
//        this.power //even child class cannot access private
        this.power2 = 4 * getPower() //protected is accessed here
        this.speed = 200 + (getPower() / 2)
    }
}

fun main() {
    val rc = RacingCar("RC1", 200.3)
    println(rc.name)
    val frc = FastestRacingCar("FRC1", 300.0)
//    frc.power //private
//    frc.power2 //protected
    println("${frc.name} ${frc.speed}")
    println("frc.getPower(): ${frc.getPower()}")
    println("frc.getSuperPower(): ${frc.getSuperPower()}")
    val sfrc = SuperFastestRacingCar("SFRC1", 500.0)

    //====================typecasting=======================
    val sc:CarSimple = RacingCar("RCSC",200.0)
    //OR
    val sc2 = RacingCar("RCSC2",200.0) as CarSimple
//    val rc2:RacingCar = CarSimple() //error
}


/*
* val obj:parent = child() //accepted
* val obj:child = parent() //not accepted
* */