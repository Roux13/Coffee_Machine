import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val equals = "equals"
    val plus = "plus"
    val endsWith = "endsWith"
    val unknownOperation = "Unknown operation"

    val first = scanner.nextLine()
    val operation = scanner.nextLine()
    val second = scanner.nextLine()

    println(when (operation) {
        equals -> first == second
        plus -> "$first$second"
        endsWith -> first.endsWith(second)
        else -> unknownOperation
    })
    // write your code here
}