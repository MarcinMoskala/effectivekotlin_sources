package f_C7_Item47.s_1

class Snapshot(
    var afterHours: SessionDetails,
    var preMarket: SessionDetails,
    var regularHours: SessionDetails,
)

data class SessionDetails(
    val open: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val close: Double? = null,
    val volume: Long? = null,
    val dollarVolume: Double? = null,
    val trades: Int? = null,
    val last: Double? = null,
    val time: Int? = null,
)
