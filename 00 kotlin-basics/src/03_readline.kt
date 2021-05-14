fun main(){
    print("Name: ")
    val name = readLine()?.toString()
    print("Age: ")
    val age = readLine()?.toInt()
    print("GPA: ")
    val gpa = readLine()?.toDouble()
    println("$name $age $gpa")
}