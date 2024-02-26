package f_C6_Item37.s_1

data class User(val name: String)

fun main() {
    val user = User("John")

    // Don't do that
    val (name) = user
    print(name) // John

    user.let { a -> print(a) } // User(name=John)
    // Don't do that
    user.let { (a) -> print(a) } // John
}
