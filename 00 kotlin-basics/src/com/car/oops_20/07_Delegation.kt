package com.car.oops_20

class Zoo(animal: Animal) : Animal by animal{
    fun print(){

    }
}

fun main() {
    val cat = Cat()
    cat.makeSound()
    cat.purr()
    val zoo = Zoo(cat)
    zoo.makeSound()
//    zoo.purr() //there is no purr() in zoo
}

/*
* Delegation
* Delegation is commonly defined as the shifting of authority and responsibility
* for particular functions, tasks or decisions from
* one person (usually a leader or manager) to another
* */