package f_C6_Item44.s_2

class User(
   val name: String,
   val surname: String
) : Comparable<User> {
   override fun compareTo(other: User): Int =
       compareValues(surname, other.surname)
}
