package f_C1_Item02.s_4

data class User(val name: String)

class UserRepository {
    private val users: MutableList<User> = mutableListOf()

    fun loadAll(): List<User> = users

    fun add(user: User) {
        users += user
    }
}

class UserRepositoryTest {
    fun `should add elements`() {
        val repo = UserRepository()
        val oldElements = repo.loadAll()
        repo.add(User("B"))
        val newElements = repo.loadAll()
        assert(oldElements != newElements)
        // This assertion will fail, because both references
        // point to the same object, and they are equal
    }
}
