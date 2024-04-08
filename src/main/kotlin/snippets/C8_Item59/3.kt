package f_C8_Item59.s_3

inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    var destination = listOf<R>()
    for (item in this)
        destination += transform(item)
    return destination
}
