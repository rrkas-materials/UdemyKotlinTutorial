class MyThread(val tname: String) : Thread() {
    var c = 0

    init {
        println("$tname init")
    }

    override fun run() {
        while (c < 10) {
            c++
            println("$tname: $c")
            try {
                sleep(200)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}

fun main() {
    val mts = arrayListOf(
        MyThread("t1"),
        MyThread("t2"),
        MyThread("t3"),
        MyThread("t4"),
        MyThread("t5"),
        MyThread("t6"),
        MyThread("t7"),
        MyThread("t8"),
    )
    mts.forEach { t -> t.start() }
    mts[5].join(1000)
    var c = 0
    while (c < 10) {
        c++
        println("main: $c")
    }
    /*
    * start: starts thread
    * run: simply calls run, without starting thread
    * */
}