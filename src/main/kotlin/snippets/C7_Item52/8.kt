package f_C7_Item52.s_8

typealias Seconds = Int
typealias Millis = Int

fun getTime(): Millis = 10
fun setUpTimer(time: Seconds) {}

fun main() {
   val seconds: Seconds = 10
   val millis: Millis = seconds // No compiler error

   setUpTimer(getTime())
}
