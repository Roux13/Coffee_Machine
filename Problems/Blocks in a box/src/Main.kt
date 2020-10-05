data class Block(val color: String) {

    object DimProperties {
        var length = 1
        var width = 1

        fun blocksInBox(boxLength: Int, boxWidth: Int): Int {
            val lengthCapacity = boxLength / this.length
            val widthCapacity = boxWidth / this.width
            return lengthCapacity * widthCapacity
        }
    }
}
