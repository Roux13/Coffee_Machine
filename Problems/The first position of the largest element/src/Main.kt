import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var max = scanner.nextInt()
    var currentPos = 1
    var maxPos = currentPos
    while (scanner.hasNext()) {
        val num = scanner.nextInt()
        currentPos++
        if (num > max) {
            max = num
            maxPos = currentPos
        }
    }
    println("$max $maxPos")
    // put your code here
}