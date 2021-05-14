package com.car.oops_20

class UserAdmin<T>(var credit: T) {
    init {
        println(credit)
    }
}

fun <T> display(msg: T) {
    println(msg)
}

fun <T> add(arg1: T, arg2: T): T {
    return arg1.also { println(arg2) }
}

fun main() {
    val ua1 = UserAdmin(2)
    ua1.credit = 5
    display<Int>(ua1.credit)
    val ua2 = UserAdmin("RA")
    ua2.credit = "RA2"
    display<String>(ua2.credit)
    println(add(1,2))
    println(add("a","b"))
    //...
}