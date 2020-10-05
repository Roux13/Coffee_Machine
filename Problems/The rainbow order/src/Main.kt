import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow.getColorNumber(input.nextLine()))
}

enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET;

    companion object {
        fun getColorNumber(name: String): Int {
            for (enum in values()) {
                if (name.toUpperCase() == enum.name) {
                    return enum.ordinal + 1
                }
            }
            return 0
        }
    }
}