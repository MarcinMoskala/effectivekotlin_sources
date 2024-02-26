package f_C4_Item30.s_4

// Product of all numbers in a list
fun List<Int>.product() = fold(1) { acc, i -> acc * i }
