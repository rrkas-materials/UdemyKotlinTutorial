fun main() {
    val map = hashMapOf<Int, String>()
    var roll: Int
    var name: String
    do {
        print("roll: ")
        roll = readLine()!!.toInt()
        print("name: ")
        name = readLine()!!
        if (roll != 0)
            map[roll] = name
    } while (roll != 0)
    map.forEach { (r, n) -> println("$r : $n") }
}