package f_C8_Item55.s_1

import kotlin.*

data class User(val id: Int, val name: String)

fun main() {
    val users = listOf(User(1, "Michal"), User(2, "Michal"))
    val byId = users.associateBy { it.id }
    println(byId.values)
    // [User(id=1, name=Michal), User(id=2, name=Michal)]
}
