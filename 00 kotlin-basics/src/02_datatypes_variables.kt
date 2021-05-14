var str7: String = "RA"

fun main() {
    //======================val================================

    val str = "String 1"
    println(str)
    println(str)

    val str2: String //separate declaration and init
    str2 = "String 2"
    println(str2)


    val str3: String = "String 3"
    println(str3)

    val age: Int = 20
    println("Int: " + age)

    val GPA: Double = 9.6
    println("Double: $GPA")

    val t = 20
//    t = 30 //error: val is like const/ final
    println("t $t")

    //===========================var=========================

    var t2 = 20
    t2 = 18
    println("t2 $t2")

    var str4: String
    str4 = "String 4"
    println(str4)
    str4 = "String 4.2"
    println(str4)

    //=========================Null Safety==========================

    var str5: String? = null // can be null
    var len = str5?.length
    println("str5: $str5 $len")
    print("Enter str5: ")
    str5 = readLine()
    len = str5?.length
    println("str5!!: ${str5!!} $len")

    //Normal
    var str6: String = "" // cannot be null
    var len2 = str6.length
    println("str6: $str6 $len2")
    str6 = "str 6"
    len2 = str6.length
    println("str6!!: $str6 $len2")

    //==================global & local variables============================


    val v = addReturn(2, 3) // globally called from 19_functions.kt
    println("v: $v")

    printStr6()
    printStr7()
    str7 = "new str7"
    printStr7()

    //==========================lambda====================================

    val sum = { a: Int, b: Int -> a + b }
    println(sum(5, 6))
    println({ a: Int, b: Int -> a + b }(7, 9))
}

fun printStr6() {
    println("Inside printStr6()")
//    println(str6) //str6 is local to main(), and inaccessible from this function
}

fun printStr7() {
    // str7 is global and can be accessed here
    println("str7: $str7")
}
