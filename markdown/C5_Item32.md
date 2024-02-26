```
//1
class LinkedList<T>(
    val head: T,
    val tail: LinkedList<T>?
)

val list = LinkedList(1, LinkedList(2, null))
```


```
class LinkedList<T>(
    val head: T,
    val tail: LinkedList<T>?
) {

    companion object {
        fun <T> of(vararg elements: T): LinkedList<T> {
            /*...*/
        }
    }
}

// Usage
val list = LinkedList.of(1, 2)
```


```
class LinkedList<T>(
    val head: T,
    val tail: LinkedList<T>?
) : MyList<T> {
    // ...
}

interface MyList<T> {
    // ...

    companion object {
        fun <T> of(vararg elements: T): MyList<T> {
            // ...
        }
    }
}

// Usage
val list = MyList.of(1, 2)
```


```
interface Tool {
    companion object { /*...*/ }
}

fun Tool.Companion.createBigTool(/*...*/): Tool {
    //...
}

val tool = Tool.createBigTool()
```


```
abstract class ActivityFactory {
    abstract fun getIntent(context: Context): Intent

    fun start(context: Context) {
        val intent = getIntent(context)
        context.startActivity(intent)
    }

    fun startForResult(
        activity: Activity,
        requestCode: Int
    ) {
        val intent = getIntent(activity)
        activity.startActivityForResult(
            intent,
            requestCode
        )
    }
}

class MainActivity : AppCompatActivity() {
    //...

    companion object : ActivityFactory() {
        override fun getIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java)
    }
}

// Usage
val intent = MainActivity.getIntent(context)
MainActivity.start(context)
MainActivity.startForResult(activity, requestCode)
```


```
class MainActivity : Activity {

    companion object {
        fun getIntent(context: Context) =
            Intent(context, MainActivity::class.java)
    }
}
```


```
intentFor<MainActivity>()
```


```
intentFor<MainActivity>("page" to 2, "row" to 10)
```


```
val list = buildList {
    add(1)
    add(2)
    add(3)
}
println(list) // [1, 2, 3]

val s = sequence {
    yield("A")
    yield("B")
    yield("C")
}
println(s.toList()) // [A, B, C]
```


```
// Starting a coroutine
scope.launch {
    val processes = repo.getActiveProcesses()
    for (process in processes) {
        launch {
            process.start()
            repo.markProcessAsDone(process.id)
        }
    }
}

// Defining a flow
val flow = flow {
    var lastId: String = null
    do {
        val page = fetchPage(lastId)
        emit(page.data)
        lastId = page.lastId
    } while (!page.isLast)
}
```


```
val sequence: Sequence = list.asSequence()

val double: Double = i.toDouble()

val flow: Flow = observable.asFlow()
```


```
//2
fun main() {
    val seq1 = sequence<Int> {
        repeat(10) {
            print(it)
            yield(10)
        }
    }
    seq1.asSequence() // Nothing printed
    seq1.toList() // Prints 0123456789


    val l1 = mutableListOf(1, 2, 3, 4)
    val l2 = l1.toList()
    val seq2 = l1.asSequence()
    l1.add(5)
    println(l2) // Prints [1, 2, 3, 4]
    println(seq2.toList()) // Prints [1, 2, 3, 4, 5]
}
```


```
class User(
    val id: UserId,
    val name: String,
    val surname: String,
    val age: Int,
    val tokens: List<Token>
)

class UserJson(
    val id: UserId,
    val name: String,
    val surname: String,
    val age: Int,
    val tokens: List<Token>
)

fun User.toUserJson() = UserJson(
    id = this.id,
    name = this.name,
    surname = this.surname,
    age = this.age,
    tokens = this.tokens
)

fun UserJson.toUser() = User(
    id = this.id,
    name = this.name,
    surname = this.surname,
    age = this.age,
    tokens = this.tokens
)
```


```
val user2 = user.copy()
val user3 = user.withSurname(newSurname)
```


```
//3
class A

fun b() = A()

val a1 = A()
val a2 = b()
```


```
val reference: () -> A = ::A
```


```
List(4) { "User$it" } // [User0, User1, User2, User3]
```


```
//4
public inline fun <T> List(
    size: Int,
    init: (index: Int) -> T
): List<T> = MutableList(size, init)

public inline fun <T> MutableList(
    size: Int,
    init: (index: Int) -> T
): MutableList<T> {
    val list = ArrayList<T>(size)
    repeat(size) { index -> list.add(init(index)) }
    return list
}
```


```
fun Job(parent: Job? = null): CompletableJob =JobImpl(parent)

fun CoroutineScope(context: CoroutineContext):CoroutineScope= 
   ContextScope(
       if (context[Job] != null) context else context + Job()
   )
```


```
class Tree<T> {

    companion object {
        operator fun <T> invoke(
            size: Int,
            generator: (Int) -> T
        ): Tree<T> {
            //...
        }
    }
}

// Usage
Tree(10) { "$it" }
```


```
Tree.invoke(10) { "$it" }
```


```
data class Student(
    val id: Int,
    val name: String,
    val surname: String
)

class StudentsFactory {
    var nextId = 0
    fun next(name: String, surname: String) =
        Student(nextId++, name, surname)
}

val factory = StudentsFactory()
val s1 = factory.next("Marcin", "Moskala")
println(s1) // Student(id=0, name=Marcin, Surname=Moskala)
val s2 = factory.next("Igor", "Wojda")
println(s2) // Student(id=1, name=Igor, Surname=Wojda)
```


```
class UserFactory(
    private val uuidProvider: UuidProvider,
    private val timeProvider: TimeProvider,
    private val tokenService: TokenService,
) {
    fun create(newUserData: NewUserData): User {
        val id = uuidProvider.next()
        return User(
            id = id,
            creationTime = timeProvider.now(),
            token = tokenService.generateToken(id),
            name = newUserData.name,
            surname = newUserData.surname,
            // ...
        )
    }
}
```