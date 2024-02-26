package f_C5_Item33.s_5

class Pizza private constructor(
    val size: String,
    val cheese: Int,
    val olives: Int,
    val bacon: Int
) {
    class Builder(private val size: String) {
        private var cheese: Int = 0
        private var olives: Int = 0
        private var bacon: Int = 0

        fun setCheese(value: Int): Builder {
            cheese = value
            return this
        }

        fun setOlives(value: Int): Builder {
            olives = value
            return this
        }

        fun setBacon(value: Int): Builder {
            bacon = value
            return this
        }

        fun build() = Pizza(size, cheese, olives, bacon)
    }
}
