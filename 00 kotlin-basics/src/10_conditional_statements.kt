fun main() {

    //==============================if=========================

    print("n1: ")
    val n1 = readLine()!!.toInt()
    print("n2: ")
    val n2 = readLine()!!.toInt()
    if (n1 in 20..30) {
        println("n1 in 20..30")
    } else {
        println("n1 !in 20..30")
    }
    if (n2 !in 20..30) {
        println("n2 !in 20..30")
    } else {
        println("n2 in 20..30")
    }
    if (n1 > n2 || n1 == n2) {
        println("n1 > n2 || n1 == n2")
    }
    if (n1 >= n2 && n1 in 20..30) {
        println("n1 >= n2 && n1 in 20..30")
    }
    if (n2 > n1) {
        println("n2 > n1")
    }
    if (n2 >= n1) {
        println("n2 >= n1")
    }
    if (n1 == n2) {
        println("n1 == n2")
    }
    if (n1 != n2) {
        println("n1 != n2")
    }

    //==========================if-else==============================

    print("Marks: ")
    val marks = readLine()!!.toInt()
    print("Grade = ")
    if (marks < 40) {
        println("F")
    } else if (marks in 40..49) {
        println("D")
    } else if (marks in 50..59) {
        println("C")
    } else if (marks in 60..69) {
        println("B")
    } else if (marks in 70..79) {
        println("A")
    } else if (marks in 80..89) {
        println("E")
    } else if (marks in 90..100) {
        println("O")
    }

    //===============================when==========================

    when {
        marks < 40 -> println("F")
        marks in 40..49 -> println("D")
        marks in 50..59 -> println("C")
        marks in 60..69 -> println("B")
        marks in 70..79 -> println("A")
        marks in 80..89 -> println("E")
        marks in 90..100 -> println("O")
    }

    print("Menu Id: ")
    val menuId = readLine()!!.toInt()
    print("Item: ")
    when (menuId) {
        1 -> {
            println("Starter")
        }
        2 -> {
            println("Main Course")
        }
        3 -> {
            println("Desert")
        }
        else -> {
            println("Drinks")
        }

    }

    //====================if and when expressions=======================
    print("Age: ")
    val age = readLine()!!.toInt()
    println(if (age > 18) "Legal" else "Illegal")
    println(
        when {
            age > 18 -> "Legal"
            else -> "Illegal"
        }
    )
}