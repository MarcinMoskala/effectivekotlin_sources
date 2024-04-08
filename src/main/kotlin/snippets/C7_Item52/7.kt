package f_C7_Item52.s_7

@JvmInline
value class Millis(val milliseconds: Long) {
   val millis: Long get() = milliseconds
}

fun setUpTimer(time: Millis?) {
   val millis = time?.millis
   //...
}

fun setUpTimer(time: Millis) {
   val millis = time.millis
   //...
}

fun main() {
   setUpTimer(Millis(456789))
}
