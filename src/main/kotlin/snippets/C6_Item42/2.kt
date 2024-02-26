package f_C6_Item42.s_2

sealed class Time
data class TimePoint(val millis: Long) : Time()
object Now : Time()
