package com.car.oops_20

data class Person(val name: String, val age: Int)

fun main() {
    val persons = arrayListOf(
        Person("A", 1),
        Person("B", 2),
        Person("C", 3),
        Person("D", 4),
    )
    persons.forEach { p -> println("${p.name} ${p.age}") }
}