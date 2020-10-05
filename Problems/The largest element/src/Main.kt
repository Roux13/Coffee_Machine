import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var max: Int = Int.MIN_VALUE
    var num = scanner.nextInt()
    if (num > max && num != 0) {
        max = num
    }
    while (num != 0) {
        num = scanner.nextInt()
        if (num > max) {
            max = num
        }
    }
    println(max)
    // put your code here
}