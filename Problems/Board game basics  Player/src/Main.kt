data class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var id = 0
        private const val defaultHp = 100

        fun create(name: String): Player {
            return Player(id++, name, defaultHp)
        }

    }
}