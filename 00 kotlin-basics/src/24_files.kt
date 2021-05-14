import java.io.FileReader
import java.io.FileWriter

fun main() {
    print("file path (no path or extension): "); val fileName = readLine()!!
    print("text: "); val text = readLine()!!
    write("src/$fileName.txt", text)
}

fun write(filePath: String, text: String) {
    println("==========WRITING=============")
    try{
        val fout = FileWriter(filePath, true)
        fout.write(text)
        fout.close()
        println(filePath)
        println(text)
        println("==========SUCCESS=============")
        read(filePath)
    }catch(e:Exception){
        println("==========FAILED=============")
        print(e.message)
    }
}

fun read(filePath: String){
    println("==========READING=============")
    try{
        val fin = FileReader(filePath)
        val c = fin.readText()
        fin.close()
        println(filePath)
        println(c)
        println("==========SUCCESS=============")
    }catch(e:Exception){
        println("==========FAILED=============")
        print(e.message)
    }
}