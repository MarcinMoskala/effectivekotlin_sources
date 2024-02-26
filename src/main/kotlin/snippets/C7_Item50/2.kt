package f_C7_Item50.s_2

fun <T : Comparable<T>> Iterable<T>.countMax(): Int {
    val max = this.maxOrNull()
    return count { it == max }
}
