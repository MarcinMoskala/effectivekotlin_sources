```
// Part of Stack<T>
fun pop(num: Int = 1): List<T> {
    require(num <= size) {
        "Cannot remove more elements than current size"
    }
    check(isOpen) { "Cannot pop from closed stack" }
    val ret = collection.take(num)
    collection = collection.drop(num)
    return ret
}
```


```
fun factorial(n: Int): Long {
    require(n >= 0)
    return if (n <= 1) 1 else factorial(n - 1) * n
}

fun findClusters(points: List<Point>): List<Cluster> {
    require(points.isNotEmpty())
    //...
}

fun sendEmail(user: User, message: String) {
    requireNotNull(user.email)
    require(isValidEmail(user.email))
    //...
}
```


```
fun factorial(n: Int): Long {
    require(n >= 0) {
        "Cannot calculate factorial of $n " +
        "because it is smaller than 0"
    }
    return if (n <= 1) 1 else factorial(n - 1) * n
}
```


```
data class User(
    val name: String,
    val email: String
) {
    init {
        require(name.isNotEmpty())
        require(isValidEmail(email))
    }
}
```


```
fun speak(text: String) {
    check(isInitialized)
    //...
}

fun getUserInfo(): UserInfo {
    checkNotNull(token)
    //...
}

fun next(): T {
    check(isOpen)
    //...
}
```


```
public inline fun require(value: Boolean): Unit {
    contract {
        returns() implies value
    }
    require(value) { "Failed requirement." }
}
```


```
fun changeDress(person: Person) {
    require(person.outfit is Dress)
    val dress: Dress = person.outfit
    //...
}
```


```
class Person(val email: String?)

fun sendEmail(person: Person, message: String) {
    require(person.email != null)
    val email: String = person.email
    //...
}
```


```
class Person(val email: String?)

fun validateEmail(email: String) { /*...*/ }

fun sendEmail(person: Person, text: String) {
    val email = requireNotNull(person.email)
    validateEmail(email)
    //...
}

fun sendEmail(person: Person, text: String) {
    requireNotNull(person.email)
    validateEmail(person.email)
    //...
}
```


```
fun largestOf(a: Int, b: Int, c: Int, d: Int): Int =
    listOf(a, b, c, d).maxOrNull()!!
```


```
fun largestOf(vararg nums: Int): Int =
    nums.maxOrNull()!!

largestOf() // NPE
```


```
class UserControllerTest {
    private var dao: UserDao? = null
    private var controller: UserController? = null

    @BeforeEach
    fun init() {
        dao = mockk()
        controller = UserController(dao!!)
    }

    @Test
    fun test() {
        controller!!.doSomething()
    }
}
```


```
class UserControllerTest {
    private lateinit var dao: UserDao
    private lateinit var controller: UserController

    @BeforeEach
    fun init() {
        dao = mockk()
        controller = UserController(dao!!)
    }

    @Test
    fun test() {
        controller.doSomething()
    }
}
```


```
fun sendEmail(person: Person, text: String) {
    val email: String = person.email ?: return
    //...
}
```


```
fun sendEmail(person: Person, text: String) {
    val email: String = person.email ?: run {
        log("Email not sent, no email address")
        return
    }
    //...
}
```


```
// error implementation from Kotlin stdlib
public inline fun error(message: Any): Nothing = 
    throw IllegalStateException(message.toString())

// example usage
fun handleMessage(message: Message) = when(message) {
    is TextMessage -> showTest(message.text)
    is ImageMessage -> showImage(message.image)
    else -> error("Unknown message type")
}
```