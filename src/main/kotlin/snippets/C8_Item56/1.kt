package f_C8_Item56.s_1

public inline fun <T, K> Iterable<T>.groupingBy(
    crossinline keySelector: (T) -> K
): Grouping<T, K> {
    return object : Grouping<T, K> {
        override fun sourceIterator(): Iterator<T> =
            this@groupingBy.iterator()
        override fun keyOf(element: T): K =
            keySelector(element)
    }
}
