import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val string = scanner.nextLine()
    val num = scanner.nextInt()

    println("Symbol # $num of the string \"$string\" is '${string[num - 1]}'")

    // write your code here
}