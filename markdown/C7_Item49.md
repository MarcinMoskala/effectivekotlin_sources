```
class WebUserRepository(
    val userClient: UserClient
) : UserRepository {
    override suspend fun getUser(id: Int): User =
        userClient.fetchUser(id)
}
```


```
class CachedWebUserRepository(
    val userClient: UserClient
) : UserRepository {
    private val users = ConcurrentHashMap<Int, User>()
    
    override suspend fun getUser(id: Int): User =
        users.getOrPut(id) { userClient.fetchUser(id) }
}
```


```
class CachedWebUserRepository(
    val userClient: UserClient
) : UserRepository {

    private val users = Caffeine.newBuilder()
        .expireAfterWrite(1, TimeUnit.MINUTES)
        .buildSuspending<Int, User>()

    override suspend fun getUser(id: Int): User =
        users.get(id) { userClient.fetchUser(id) }
}
```


```
private val connections =
    ConcurrentHashMap<String, Connection>()

fun getConnection(host: String) =
    connections.getOrPut(host) { createConnection(host) }
```


```
class CachedWebUserRepository(
    val userClient: UserClient
) : UserRepository {

   private val users = Caffeine.newBuilder()
      .maximumSize(10_000)
      // When size is reached, less used entries are removed
      .expireAfterAccess(10, TimeUnit.MINUTES)
      //When entry is not used for 10 minutes, it is removed
      .softValues() // Using soft references
      .buildSuspending<Int, User>()
   
   override suspend fun getUser(id: Int): User =
       users.get(id) { userClient.fetchUser(id) }
}
```