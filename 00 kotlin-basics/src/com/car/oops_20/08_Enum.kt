package com.car.oops_20

enum class Direction { NORTH, SOUTH, EAST, WEST }

fun main() {
    Direction.values().forEach { d -> println(d) }
    println("======================")
    val dir = Direction.NORTH
    print("dir : ")
    when(dir){
        Direction.NORTH -> println("North")
        Direction.SOUTH -> println("South")
        Direction.EAST -> println("East")
        Direction.WEST -> println("West")
    }
}