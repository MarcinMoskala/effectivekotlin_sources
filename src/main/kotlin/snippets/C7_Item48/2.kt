package f_C7_Item48.s_2

sealed class ValueChange<out T>
data object Keep : ValueChange<Nothing>()
data object SetDefault : ValueChange<Nothing>()
data object SetEmpty : ValueChange<Nothing>()
data class Set<out T>(val value: T) : ValueChange<T>()


sealed class ManagerMessage
data class CodeProduced(val code: String) : ManagerMessage()
data object ProductionStopped : ManagerMessage()


sealed interface AdView
data object FacebookAd : AdView
data object GoogleAd : AdView
data class OwnAd(val text: String,val imgUrl: String):AdView
