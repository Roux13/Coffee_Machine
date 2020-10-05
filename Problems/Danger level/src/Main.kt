enum class DangerLevel(val degree: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = this.degree
}