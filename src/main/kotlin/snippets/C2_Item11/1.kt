package f_C2_Item11.s_1

fun Int.factorial(): Int = (1..this).product()

fun Iterable<Int>.product(): Int =
   fold(1) { acc, i -> acc * i }
