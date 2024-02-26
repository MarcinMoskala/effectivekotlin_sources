```
// Java
public class JavaTest {

    public String giveName() {
        // ...
    }
}
```


```
// Java
public class UserRepo {

    public List<User> getUsers() {
        //***
    }
}
```


```
// Kotlin
val users: List<User> = UserRepo().users!!.filterNotNull()
```


```
val users: List<List<User>> = UserRepo().groupedUsers!!
    .map { it!!.filterNotNull() }
```


```
// Java
public class UserRepo {
    public User getUser() {
        //...
    }
}
```


```
// Kotlin
val repo = UserRepo()
val user1 = repo.user        // Type of user1 is User!
val user2: User = repo.user  // Type of user2 is User
val user3: User? = repo.user // Type of user3 is User?
```


```
val users: List<User> = UserRepo().users
val users: List<List<User>> = UserRepo().groupedUsers
```


```
// Java

import org.jetbrains.annotations.NotNull;

public class UserRepo {
    public @NotNull User getUser() {
        //...
    }
}
```


```
// Java
public class JavaClass {
    public String getValue() {
        return null;
    }
}
```


```
// Kotlin
fun statedType() {
    val value: String = JavaClass().value
    //...
    println(value.length)
}

fun platformType() {
    val value = JavaClass().value
    //...
    println(value.length)
}
```


```
// Java
public class JavaClass {
    public String getValue() {
        return null;
    }
}
```


```
// Kotlin
fun statedType() {
    val value: String = JavaClass().value // NPE
    //...
    println(value.length)
}

fun platformType() {
    val value = JavaClass().value
    //...
    println(value.length) // NPE
}
```


```
interface UserRepo {
    fun getUserName() = JavaClass().value
}
```


```
class RepoImpl : UserRepo {
    override fun getUserName(): String? {
        return null
    }
}

fun main() {
    val repo: UserRepo = RepoImpl()
    val text: String = repo.getUserName() // NPE in runtime
    print("User name length is ${text.length}")
}
```