```
class ConfigurationRepository(
    private val configurations: List<Configuration>
) {
    fun getByName(name: String) = configurations
        .firstOrNull { it.name == name }
}

class NetworkUserRepo(
    private val userService: UserService
) : UserRepo {
    
    private var users: List<User>? = null
    
    suspend fun loadUsers() {
        users = userService.getUsers()
    }
    
    override fun getUser(id: UserId): User? = users
        ?.firstOrNull { it.id == id }
}

class InMemoryUserRepo : UserRepo {
    
    private val users: MutableList<User> = mutableListOf()
    
    override fun getUser(id: UserId): User? = users
        .firstOrNull { it.id == id }
    
    fun addUser(user: User) {
        user.add(user)
    }
}
```


```
class InMemoryUserRepo : UserRepo {
    private val users: MutableMap<UserId, User> =
        mutableMapOf()
    
    override fun getUser(id: UserId): User? = users[id]
    
    fun addUser(user: User) {
        user.put(user.id, user)
    }
}
```


```
data class User(val id: Int, val name: String)

val users = listOf(User(1, "Michal"), User(2, "Marek"))

val nameById: Map<Int, String> =
    users.associate { it.id to it.name }
println(byId) // {1=Michal, 2=Marek}
```


```
val byId: Map<Int, User> = users.associateBy { it.id }
println(byId)
// {1=User(id=1, name=Michal),
// 2=User(id=2, name=Marek)}

val byName: Map<String,User> = users.associateBy { it.name }
println(byName)
// {Michal=User(id=1, name=Michal),
// Marek=User(id=2, name=Marek)}
```


```
val users2 = listOf(User(1, "Michal"), User(2, "Michal"))

val byName = users2.associateBy { it.name }
println(byName) // {Michal=User(id=2, name=Michal)}
```


```
//1
import kotlin.*

data class User(val id: Int, val name: String)

fun main() {
    val users = listOf(User(1, "Michal"), User(2, "Michal"))
    val byId = users.associateBy { it.id }
    println(byId.values)
    // [User(id=1, name=Michal), User(id=2, name=Michal)]
}
```


```
class ConfigurationRepository(
    configurations: List<Configuration>
) {
    private val configurations: Map<String, Configuration> =
        configurations.associateBy { it.name }
    
    fun getByName(name: String) = configurations[name]
}

class NetworkUserRepo(
    private val userService: UserService
) : UserRepo {
    
    private var users: Map<UserId, User>? = null
    
    suspend fun loadUsers() {
        users = userService.getUsers()
            .associateBy { it.id }
    }
    
    override fun getUser(id: UserId): User? = users?.get(id)
}
```


```
fun produceArticlesWithAuthors(
    articles: List<Article>,
    authors: List<Author>
): List<ArticleWithAuthor> {
    return articles.map { article ->
        val author = authors
            .first { it.id == article.authorId }
        ArticleWithAuthor(article, author)
    }
}
```


```
fun produceArticlesWithAuthors(
    articles: List<Article>,
    authors: List<Author>
): List<ArticleWithAuthor> {
    val authorsById = authors.associateBy { it.id }
    return articles.map { article ->
        val author = authorsById[article.authorId]
        ArticleWithAuthor(article, author)
    }
}
```