package f_C6_Item44.s_1

class User(val name: String, val surname: String)

val names = listOf<User>(/*...*/)

val sorted = names.sortedBy { it.surname }
