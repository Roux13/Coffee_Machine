import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val triangle = "triangle"
    val rectangle = "rectangle"
    val circle = "circle"

    val shape = scanner.nextLine()

    when (shape) {
        triangle -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val c = scanner.nextDouble()
            val p = 0.5 * (a + b + c)
            val square = sqrt(p * (p - a) * (p - b) * (p - c))
            println("${BigDecimal(square).setScale(1, RoundingMode.HALF_DOWN).toDouble()}")
        }
        rectangle -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val square = a * b
            println("${BigDecimal(square).setScale(1, RoundingMode.HALF_DOWN).toDouble()}")
        }
        circle -> {
            val r = scanner.nextDouble()
            val square = PI * r.pow(2)
            println("${BigDecimal(square).setScale(1, RoundingMode.HALF_DOWN).toDouble()}")
        }
    }

    // write your code here
}