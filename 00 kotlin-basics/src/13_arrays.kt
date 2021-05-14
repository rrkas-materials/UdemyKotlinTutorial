fun main() {
    //=========================1-Dimensional=================================
    val list = Array(5) { 0 }
    list.forEach { i -> print("$i ") }
    println()
    for (i in 0..4) {
        print("v: ")
        list[i] = readLine()!!.toInt()
    }
    list.forEach { i -> print("$i ") }
    println()
    println("Average: ${list.average()}")

    val list2 = Array(5) { "_" }
    list2.forEach { i -> print("$i ") }
    println()
    for (i in 0..4) {
        print("v: ")
        list2[i] = readLine()!!
    }
    list2.forEach { i -> print("$i ") }
}