package f_C7_Item52.s_1

@JvmInline
value class Millis(val milliseconds: Long) {
   val millis: Long get() = milliseconds
}

// the type under the hood is @Nullable Millis
fun setUpTimer(time: Millis?) {
   val millis = time?.millis
   //...
}

// the type under the hood is long
fun setUpTimer(time: Millis) {
   val millis = time.millis
   //...
}

fun main() {
   setUpTimer(Millis(456789))
}
