import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow.isRainbowColor(input.nextLine()))
}

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    companion object {
        fun isRainbowColor(name: String): Boolean {
            for (color in values()) {
                if (color.name == name.toUpperCase()) return true
            }
            return false
        }
    }
}