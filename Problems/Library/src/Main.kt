object Math {
    fun abs(num: Int): Int {
        return if (num < 0) { 
            -num
        } else {
            num
        }
    }

    fun abs(num: Double): Double {
        return if (num < 0.0) {
            -num
        } else {
            num
        }
    }
}
