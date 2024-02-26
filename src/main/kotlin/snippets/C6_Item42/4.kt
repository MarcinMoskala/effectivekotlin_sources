package f_C6_Item42.s_4

open class Date(
    val year: Int,
    val month: Int,
    val day: Int
) {
    // DO NOT DO THIS, symmetric but not transitive
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> this == o.date
        is Date -> o.day == day &&
                o.month == month &&
                o.year == year
        else -> false
    }

    // ...
}

class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
) : Date(date.year, date.month, date.day) {
    // DO NOT DO THIS, symmetric but not transitive
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> o.date == date &&
                o.hour == hour &&
                o.minute == minute &&
                o.second == second
        is Date -> date == o
        else -> false
    }

    // ...
}
