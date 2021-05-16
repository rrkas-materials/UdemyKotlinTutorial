package com.car.oops_20

class Outer{
    private val oname = "outer - private name"
    val opname = "outer - public name"

    init {
        println(oname)
        println(opname)
    }

    inner class Inner{
        private val iname = "inner - private name"
        val ipname = "inner - public name"
        init {
            println(oname)
            println(opname)
            println(iname)
            println(ipname)
        }
    }

    class Nested{
        private val nname = "nested - private name"
        val npname = "nested - public name"
        init {
//            println(oname) //error
//            println(opname) //error
            println(nname)
            println(npname)
        }
    }
}

fun main() {
    val outer = Outer()
    val inner = outer.Inner() //using outer object
    val nested = Outer.Nested() //like static member
}