import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val stay = "do not move"
    val up = "move up"
    val down = "move down"
    val left = "move left"
    val right = "move right"
    val error = "error!"

    val input = scanner.nextInt()
    println(when (input) {
        0 -> stay
        1 -> up
        2 -> down
        3 -> left
        4 -> right
        else -> error
    })

    // write your code here
}