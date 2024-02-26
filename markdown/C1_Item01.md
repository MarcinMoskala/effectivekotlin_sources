```
//1
var a = 10
val list: MutableList<Int> = mutableListOf()
```


```
class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()

val account = BankAccount()
println(account.balance) // 0.0
account.deposit(100.0)
println(account.balance) // 100.0
account.withdraw(50.0)
println(account.balance) // 50.0
```


```
val a = 10
a = 20 // ERROR
```


```
val list = mutableListOf(1, 2, 3)
list.add(4)

print(list) // [1, 2, 3, 4]
```


```
//2
var name: String = "Marcin"
var surname: String = "Moskała"
val fullName
    get() = "$name $surname"

fun main() {
    println(fullName) // Marcin Moskała
    name = "Maja"
    println(fullName) // Maja Moskała
}
```


```
//3
fun calculate(): Int {
    print("Calculating... ")
    return 42
}

val fizz = calculate() // Calculating...
val buzz
    get() = calculate()

fun main() {
    print(fizz) // 42
    print(fizz) // 42
    print(buzz) // Calculating... 42
    print(buzz) // Calculating... 42
}
```


```
//4
interface Element {
    val active: Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}
```


```
val name: String? = "Márton"
val surname: String = "Braun"

val fullName: String?
    get() = name?.let { "$it $surname" }

val fullName2: String? = name?.let { "$it $surname" }

fun main() {
    if (fullName != null) {
        println(fullName.length) // ERROR
    }

    if (fullName2 != null) {
        println(fullName2.length) // 12
    }
}
```


```
//5
inline fun <T, R> Iterable<T>.map(
    transformation: (T) -> R
): List<R> {
    val list = ArrayList<R>()
    for (elem in this) {
        list.add(transformation(elem))
    }
    return list
}
```


```
val list = listOf(1, 2, 3)

// DON’T DO THIS!
if (list is MutableList) {
    list.add(4)
}
```


```
val list = listOf(1, 2, 3)

val mutableList = list.toMutableList()
mutableList.add(4)
```


```
val names: SortedSet<FullName> = TreeSet()
val person = FullName("AAA", "AAA")
names.add(person)
names.add(FullName("Jordan", "Hansen"))
names.add(FullName("David", "Blanc"))

print(s) // [AAA AAA, David Blanc, Jordan Hansen]
print(person in names) // true

person.name = "ZZZ"
print(names) // [ZZZ AAA, David Blanc, Jordan Hansen]
print(person in names) // false
```


```
class User(
    val name: String,
    val surname: String
) {
    fun withSurname(surname: String) = User(name, surname)
}

var user = User("Maja", "Markiewicz")
user = user.withSurname("Moskała")
print(user) // User(name=Maja, surname=Moskała)
```


```
data class User(
    val name: String,
    val surname: String
)

var user = User("Maja", "Markiewicz")
user = user.copy(surname = "Moskała")
print(user) // User(name=Maja, surname=Moskała)
```


```
//6
val list1: MutableList<Int> = mutableListOf()
var list2: List<Int> = listOf()
```


```
list1.add(1)
list2 = list2 + 1
```


```
list1 += 1 // Translates to list1.plusAssign(1)
list2 += 1 // Translates to list2 = list2.plus(1)
```


```
var list = listOf<Int>()
for (i in 1..1000) {
    thread {
        list = list + i
    }
}
Thread.sleep(1000)
print(list.size) // Very unlikely to be 1000,
// every time a different number, like for instance 911
```


```
var names by observable(listOf<String>()) { _, old, new ->
    println("Names changed from $old to $new")
}

names += "Fabio"
// Names changed from [] to [Fabio]
names += "Bill"
// Names changed from [Fabio] to [Fabio, Bill]
```


```
var announcements = listOf<Announcement>()
    private set
```


```
//7
// Don’t do that
var list3 = mutableListOf<Int>()
```