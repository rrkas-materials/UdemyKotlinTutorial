fun main() {

    //=======================for=================================

    for (i in 1..5) {
        println("Simple For: $i")
    }
    for (i in 1..10 step 2) {
        println("For with step 2: $i")
    }
    for (i in 5..1) { // no output n1..n2 n2>=n1
        println("Reverse For: $i")
    }
    for (i in 5 downTo 1) {
        println("Downto For: $i")
    }
    for (i in 10 downTo 1 step 2) {
        println("Downto For with step 2: $i")
    }
    for (i in 1 until 6){ // [1, 6)
        println("For until: $i")
    }

    //======================while=============================

    var i = 1 // n1
    while (i <= 5) { //n2
        println("While loop: $i")
        i++ //step
    }
    i = 1 // n1
    while (i <= 10) { //n2
        println("While loop step 2: $i")
        i += 2 //step
    }

    //===================do-while==================================

    i = 1
    do {
        println("Do-While: $i")
        i += 1
    } while (i <= 5)

    i = 10
    do {
        println("Do-While with no entry-check: $i")
        i += 1
    } while (i <= 5)

    //=====================continue & return===============================

    for (i in 1..10) {
        if (i == 3) {
            continue
        }
        if (i > 5) {
            break
        }
        println("CR: $i")
    }

    //=====================named loops===============================

    loop1@ for(i in 1..5){
        loop2@ for(j in 1..5){
            if(j==3){
                break // or break@loop2
            }
            if(i==3){
                break@loop1
            }
            println("Nested named loop $i $j")
        }
    }

}