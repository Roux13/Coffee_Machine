import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val answer = scanner.nextInt()

    println(when (answer) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })

    // write your code here
}