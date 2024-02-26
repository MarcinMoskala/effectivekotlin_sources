package f_C6_Item42.s_1

class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    override fun equals(other: Any?): Boolean =
        other is User && other.id == id

    override fun hashCode(): Int = id
}
