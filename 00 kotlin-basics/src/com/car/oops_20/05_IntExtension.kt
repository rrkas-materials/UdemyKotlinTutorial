package com.car.oops_20

fun Int.add(int: Int): Int {
    return this + int
}

fun main() {
    val i = 2
    println("i: $i")
    println("i.add(5): ${i.add(5)}")
}