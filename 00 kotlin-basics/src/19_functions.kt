fun main() {
    display()
    val n1 = inputInt("n1")
    val n2 = inputInt("n2")
    addPrint(n1, n2)
    addPrint()
    addPrint(30)
    addPrint(b = 30)
    addPrint(n1 * 1.0, n2 * 1.0)
    println(addReturn(n1, n2))
    addAll()
    addAll(1, 2, 3)
    addAll(*intArrayOf(0, 1, 2)) //* is spread operator

    /*
    * Polymorphism
    *   When a function/ object acts differently in different situations
    *
    * static polymorphism (compile time)
    *   overloading
    *
    * dynamic polymorphism (runtime)
    *   overriding
    *
    * */

}

fun display() {
    println("==========FUNCTIONS==============")
}

fun inputInt(message: String): Int {
    print("$message: ")
    return readLine()!!.toInt()
}

fun addPrint(a: Int = 10, b: Int = 10) { // function with default arguments
    println(a + b)
}

/// function overloading on [addPrint]
fun addPrint(a: Double, b: Double) {
    println(a + b)
}

fun addReturn(a: Int, b: Int): Int {
    return a + b
}

fun addAll(vararg nums: Int) {
    //nums is of type IntArray
    println("Sum = ${nums.sum()}")
}