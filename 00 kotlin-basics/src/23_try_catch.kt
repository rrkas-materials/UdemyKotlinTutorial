fun main() {
    try {
        print("m: "); val m = readLine()!!.toInt()
        print("n: "); val n = readLine()!!.toInt()
        println(m / n)
    } catch (e: Exception) {
        println(e.message)
    }
}