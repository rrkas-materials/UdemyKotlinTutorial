import java.util.*

fun main() {
    print("Year of birth: ")
    var yob = readLine()!!.toInt()
    val currYear = Calendar.getInstance().get(Calendar.YEAR)
    print("Your age = ${currYear-yob} years")
}