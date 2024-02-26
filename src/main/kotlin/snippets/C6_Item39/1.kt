package f_C6_Item39.s_1

sealed class ValueChange<out T>
object Keep: ValueChange<Nothing>()
object SetDefault: ValueChange<Nothing>()
object SetEmpty: ValueChange<Nothing>()
class Set<out T>(val value: T): ValueChange<T>()

sealed class ManagerMessage
class CodeProduced(val code: String): ManagerMessage()
object ProductionStopped: ManagerMessage()

sealed interface AdView
object FacebookAd: AdView
object GoogleAd: AdView
class OwnAd(val text: String, val imgUrl: String): AdView
