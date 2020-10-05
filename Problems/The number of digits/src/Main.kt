import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val number = scanner.nextLine()

    println(when (number.length) {
        1 -> 1
        2 -> 2
        3 -> 3
        else -> 4
    })
    // put your code here
}