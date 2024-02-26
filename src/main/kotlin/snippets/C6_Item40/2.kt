package f_C6_Item40.s_2

sealed class ValueMatcher<T> {
    abstract fun match(value: T): Boolean

    class Equal<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value == this.value
    }

    class NotEqual<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value != this.value
    }

    class EmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isEmpty()
    }

    class NotEmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T) =
            value is List<*> && value.isNotEmpty()
    }
}
