package f_C6_Item44.s_3

class User(
    val name: String,
    val surname: String
) : Comparable<User> {
    override fun compareTo(other: User): Int =
        compareValuesBy(this, other,
            { it.surname },
            { it.name }
        )
}
