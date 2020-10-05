import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    var num = 1
    while (num * num <= n) {
        println(num * num)
        num++
    }
    // put your code here
}