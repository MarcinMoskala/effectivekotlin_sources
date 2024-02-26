```
var num = 0
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        num += 1
    }
}
Thread.sleep(5000)
print(num) // Very unlikely to be 1000
// Every time a different number
```


```
var numbers = mutableListOf<Int>()
for (i in 1..1000) {
    thread {
        Thread.sleep(1)
        numbers.add(i)
    }
    thread {
        Thread.sleep(1)
        print(numbers.sum()) // sum iterates over the list
        // often ConcurrentModificationException
    }
}
```


```
val lock = Any()
var num = 0
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        synchronized(lock) {
            num += 1
        }
    }
}
Thread.sleep(1000)
print(num) // 1000
```


```
class Counter {
    private val lock = Any()
    private var num = 0
    
    fun inc() = synchronized(lock) {
        num += 1
    }
    
    fun dec() = synchronized(lock) {
        num -= 1
    }

    // Synchronization is not necessary; however,
    // without it, getter might serve stale value
    fun get(): Int = num
}
```


```
val num = AtomicInteger(0)
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        num.incrementAndGet()
    }
}
Thread.sleep(5000)
print(num.get()) // 1000
```


```
val map = ConcurrentHashMap<Int, String>()
for (i in 1..1000) {
    thread {
        Thread.sleep(1)
        map.put(i, "E$i")
    }
    thread {
        Thread.sleep(1)
        print(map.toList().sumOf { it.first })
    }
}
```


```
val set = ConcurrentHashMap.newKeySet<Int>()
for (i in 1..1000) {
    thread {
        Thread.sleep(1)
        set += i
    }
}
Thread.sleep(5000)
println(set.size)
```


```
// Using AtomicFU
val num = atomic(0)
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        num.incrementAndGet()
    }
}
Thread.sleep(5000)
print(num.value) // 1000
```


```
data class User(val name: String)

class UserRepository {
    private val users: MutableList<User> = mutableListOf()
    
    fun loadAll(): MutableList<User> = users

    //...
}
```


```
val userRepository = UserRepository()

val users = userRepository.loadAll()
users.add(User("Kirill"))
//...

print(userRepository.loadAll()) // [User(name=Kirill)]
```


```
data class User(val name: String)

class UserRepository {
    private val users: MutableList<User> = mutableListOf()

    fun loadAll(): List<User> = users

    //...
}
```


```
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
```


```
val repo = UserRepository()
thread {
    for (i in 1..10000) repo.add(User("User$i"))
}
thread {
    for (i in 1..10000) {
        val list = repo.loadAll()
        for (e in list) {
            /* no-op */
        }
    }
}
// ConcurrentModificationException
```


```
class UserRepository {
    private val users: MutableList<User> = mutableListOf()
    private val lock = Any()

    fun loadAll(): List<User> = synchronized(lock) {
        users.toList()
    }

    fun add(user: User) = synchronized(lock) {
        users += user
    }
}
```


```
class UserRepository {
    private var users: List<User> = listOf()

    fun loadAll(): List<User> = users
    
    fun add(user: User) {
        users = users + user
    }
}
```


```
class UserRepository {
    private var users: List<User> = listOf()
    private val lock = Any()

    fun loadAll(): List<User> = users

    fun add(user: User) = synchronized(lock) {
        users = users + user
    }
}
```