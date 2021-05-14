package com.car.oops_20

//open class can be inherited
open class CarSimple {
    var name: String? = null

    init {
        println("Car object created! $name")
    }
}

//the parameters here are used in primary constructor
class CarParameters(
    val type: String,
    val model: String,
    val price: Double,
    val milesDrive: Int,
    var owner: String
) {

    init {
        println("CarParameters object created(.): $type, $model, $price, $milesDrive, $owner")
    }

    fun getCarPrice(): Double {
        return price;
    }

    fun setCarOwner(owner: String) {
        println("Owner: ${this.owner} => $owner")
        this.owner = owner
    }
}

class CarEmpty

class CarConstructorOverloaded {

    private var type: String? = null
    var model: String? = null
    private var price: Double? = null
    private var milesDrive: Int? = null
    private var owner: String? = null

    constructor(type: String, model: String, price: Double, milesDrive: Int, owner: String) {
        this.type = type
        this.model = model
        this.price = price
        this.milesDrive = milesDrive
        this.owner = owner
        println("CarConstructorOverloaded object created(.): $type, $model, $price, $milesDrive, $owner")
    }

    constructor() {
        println("CarConstructorOverloaded object created( ): $type, $model, $price, $milesDrive, $owner")
    }

    // will be called before constructor
    init {
        type = "type"
        model = "model"
        price = 3.21
        milesDrive = 4
        owner = "owner"
    }
}

class CarInitOrder(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

fun main() {
    //===================simple class==========================
    val cp1 = CarSimple()
    cp1.name = "a"
    val cp2 = CarSimple()
    cp2.name = "b"
    println("${cp1.name} ${cp2.name}")

    //===============class with properties===================
    val cp = CarParameters("BMW", "2015", 1000.0, 200, "RA")
    println(cp.milesDrive)
    println(cp.getCarPrice())
    println("cp.owner: ${cp.owner}")
    cp.setCarOwner("RA2")
    println("cp.owner: ${cp.owner}")

    //==============empty class============================
    val ce = CarEmpty()
    println("ce: ${ce.javaClass.simpleName}")

    //===============constructor overloading================
    val cco1 = CarConstructorOverloaded("BMW", "2015", 1000.0, 200, "RA")
    val cco2 = CarConstructorOverloaded()
    println("${cco1.model} ${cco2.model}")

    //==============init order==============================
    val cio = CarInitOrder("CIO")
    println(cio.firstProperty)

    //===============list of cars===========================
    val listCarSimple = ArrayList<CarSimple>();
    listCarSimple.add(CarSimple().also { c -> c.name = "abc1" })
    listCarSimple.add(CarSimple().also { c -> c.name = "abc2" })
    listCarSimple.add(CarSimple().also { c -> c.name = "abc3" })
    for (car in listCarSimple) {
        println(car.name)
    }
}