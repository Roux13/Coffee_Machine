import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val divByZero = "Division by 0!"
    val unknownOp = "Unknown operator"

    val num1 = scanner.nextLong()
    val operator = scanner.next()
    val num2 = scanner.nextLong()

    println(when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "/" -> {
            if (num2 == 0L) {
                divByZero
            } else {
                num1 / num2
            }
        }
        "*" -> num1 * num2
        else -> unknownOp
    })

    // write your code here
}