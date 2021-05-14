package com.car.oops_20

class Outer{
    private val oname = "outer - private name"
    val opname = "outer - public name"

    init {
        println(oname)
        println(opname)
    }

    class Inner{
        private val iname = "inner - private name"
        val ipname = "inner - public name"
        init {
            println(iname)
            println(ipname)
        }
    }
}

fun main() {
    val outer = Outer()
    val inner = Outer.Inner()
}