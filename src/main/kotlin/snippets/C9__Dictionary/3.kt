package f_C9__Dictionary.s_3

class User(
    val name: String,
    val surname: String
) {
    val fullName: String
        get() = "$name $surname"

    fun withSurname(surname: String) =
        User(this.name, surname)
}
