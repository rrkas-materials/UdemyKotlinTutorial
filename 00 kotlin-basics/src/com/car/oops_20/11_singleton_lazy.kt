package com.car.oops_20

class Singleton{
    var c = 0
    private constructor(){
        c++
        println("Created! $c")
    }
    companion object{
        val instance:Singleton by lazy{ Singleton() }
    }
}

fun main() {
    val s1 = Singleton.instance
    val s2 = Singleton.instance
}