package com.car.oops_20

class Student(val name:String, val roll:Int) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return name.compareTo(other.name)
    }
}

fun main() {
    val studs = arrayListOf(
        Student("A",20),
        Student("C",10),
        Student("B",30),
    )
    for(stud in studs){
        println("${stud.name} ${stud.roll}")
    }
    println("===============sort==================")
    studs.sort()
    for(stud in studs){
        println("${stud.name} ${stud.roll}")
    }
}