import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val gryffindorMessage = "bravery"
    val hufflepuffMessage = "loyalty"
    val slytherinMessage = "cunning"
    val ravenclawMessage = "intellect"
    val notValidMessage = "not a valid house"

    val house = scanner.nextLine()

    println(when (house) {
        "gryffindor" -> gryffindorMessage
        "hufflepuff" -> hufflepuffMessage
        "slytherin" -> slytherinMessage
        "ravenclaw" -> ravenclawMessage
        else -> notValidMessage
    })
    // write your code here
}