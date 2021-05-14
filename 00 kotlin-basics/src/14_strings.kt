fun main() {
    val m = "Welcome to Kotlin"
    val n = "User"
    println(m + ", " + n)
    println("$m, $n")
    println(m[0])
    println(m[5])
    println(m.uppercase())
    println(m.lowercase())
    val raw = "    This is a raw message     "
    println("raw: [$raw]")
    println("trimmed: [${raw.trim()}]")
    val words = m.split(' ')
    for (i in words) {
        if (i.contains('e') || i.startsWith('t'))
            println(i)
    }
}