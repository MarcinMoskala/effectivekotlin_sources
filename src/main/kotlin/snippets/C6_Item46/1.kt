package f_C6_Item46.s_1

fun String.isPhoneNumber(): Boolean =
    length == 7 && all { it.isDigit() }
