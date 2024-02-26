package f_C4_Item30.s_3

fun List<Int>.product() = fold(1) { acc, i -> acc * i }
