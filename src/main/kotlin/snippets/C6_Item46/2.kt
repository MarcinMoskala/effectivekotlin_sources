package f_C6_Item46.s_2

fun isPhoneNumber(`$this`: String): Boolean =
   `$this`.length == 7 && `$this`.all { it.isDigit() }
