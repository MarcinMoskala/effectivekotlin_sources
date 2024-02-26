package f_C5_Item34.s_1

inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    val list = arrayListOf<T>()
    for (elem in this) {
        if (predicate(elem)) {
            list.add(elem)
        }
    }
    return list
}
