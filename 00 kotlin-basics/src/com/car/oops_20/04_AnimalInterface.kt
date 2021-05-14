package com.car.oops_20

interface Animal {
    fun makeSound() //these must be overridden, open or not
}

class Cat : Animal {
    override fun makeSound() {
        println("Mew!")
    }

    fun purr() {
        println("Angry cat!")
    }
}

class Dog : Animal {
    override fun makeSound() {
        println("Bark!")
    }
}

fun makeAnimalSound(animal: Animal) {
    animal.makeSound()
}

fun main() {
    val cat1: Cat = Cat()
    cat1.makeSound()
    val dog1: Dog = Dog()
    dog1.makeSound()
    //============typecasting======================
    val cat2: Animal = Cat()
    //OR
    val cat3 = Cat() as Animal
    cat2.makeSound()
    val dog2: Animal = Dog()
    dog2.makeSound()
    //============array of animals======================
    val animals = arrayListOf(cat1, cat2, dog1, dog2)
    for (animal in animals) {
        makeAnimalSound(animal)
    }
}

/*
* val obj:parent = child() //accepted
* val obj:child = parent() //not accepted
* */