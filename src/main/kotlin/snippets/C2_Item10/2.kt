package f_C2_Item10.s_2

operator fun String.invoke(f: ()->String): String =
   this + f()

infix fun String.and(s: String) = this + s
