import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val square = "square"
    val circle = "circle"
    val triangle = "triangle"
    val rhombus = "rhombus"
    val noSuchShape = "There is no such shape!"

    val input = scanner.nextInt()
    val message: String
    message = if (input in 1..4) {
        "You have chosen a ${when (input) {
            1 -> square
            2 -> circle
            3 -> triangle
            4 -> rhombus
            else -> ""
        }}"
    } else {
        noSuchShape
    }
    println(message)
}