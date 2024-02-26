package f_C1_Item05.s_2

class Person(val email: String?)

fun sendEmail(person: Person, message: String) {
    require(person.email != null)
    val email: String = person.email
    //...
}
