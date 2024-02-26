package f_C1_Item02.s_2

data class User(val name: String)

class UserRepository {
    private val users: MutableList<User> = mutableListOf()
    
    fun loadAll(): MutableList<User> = users

    //...
}
