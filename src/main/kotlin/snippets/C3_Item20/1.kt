package f_C3_Item20.s_1

fun Iterable<Int>.product() =
     fold(1) { acc, i -> acc * i }
