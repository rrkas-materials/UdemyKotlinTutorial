fun main() {
    print("Num1: ")
    var num1 = readLine()!!.toInt()
    print("Num2: ")
    var num2 = readLine()!!.toInt()
    println("$num1 $num2")
    num1 += num2
    num2 = num1 - num2
    num1 -= num2
    println("$num1 $num2")
}