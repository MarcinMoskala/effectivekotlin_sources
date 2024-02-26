package f_C7_Item50.s_1

fun <T : Comparable<T>> Iterable<T>.countMax(): Int =
    count { it == this.maxOrNull() }
