package f_C8_Item59.s_2

inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    val size =
        if (this is Collection<*>) this.size else 10
    val destination = ArrayList<R>(size)
    for (item in this)
        destination.add(transform(item))
    return destination
}
