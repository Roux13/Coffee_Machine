data class City(val name: String) {
    var degrees: Int = 0
    set(value) {
        field = if (value < -92 || value > 57) {
            when (name) {
                "Moscow" -> 5
                "Hanoi" -> 20
                "Dubai" -> 30
                else -> 0
            }
        } else {
            value
        }
    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val coldestCity = when {
        firstCity.degrees < secondCity.degrees && firstCity.degrees < thirdCity.degrees -> firstCity
        secondCity.degrees < firstCity.degrees && secondCity.degrees < thirdCity.degrees -> secondCity
        thirdCity.degrees < firstCity.degrees && thirdCity.degrees < secondCity.degrees -> thirdCity
        else -> City("neither")
    }
    // implement comparing here
    print(coldestCity.name)
}