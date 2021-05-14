import java.util.*


fun main() {
    val list = LinkedList<Int>()
    var v: Int
    do {
        print("v (0 to exit): ")
        v = readLine()!!.toInt()
        if (v != 0) list.add(v)
    } while (v != 0)
    print("Elements: ")
    list.forEach { i -> print("$i ") }
    println()
    println("Sum = ${list.sum()}")
    println("Size = ${list.size}")
    println("Average: ${list.average()}")
}
