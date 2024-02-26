```
fun double(i: Int) = i * 2 // Top-level function

class A {
    fun triple(i: Int) = i * 3 // Member function

    fun twelveTimes(i: Int): Int { // Member function
        fun fourTimes() = // Local function
            double(double(i))
        return triple(fourTimes())
    }
}
```


```
val double = fun(i: Int) = i * 2 // Anonymous function
val triple = { i: Int -> i * 3 } // Lambda expression,
// which is a shorter notation for an anonymous function
```


```
class IntWrapper(val i: Int) {
    fun doubled(): IntWrapper = IntWrapper(i * 2)
}

// Usage
val wrapper = IntWrapper(10)
val doubledWrapper = wrapper.doubled()

val doubledReference = IntWrapper::doubled
```


```
fun IntWrapper.tripled() = IntWrapper(i * 3)

// Use
val wrapper = IntWrapper(10)
val tripledWrapper = wrapper.tripled()

val tripledReference = IntWrapper::tripled
```


```
class User(
    val name: String,
    val surname: String
) {
    val fullName: String
        get() = "$name $surname"

    fun withSurname(surname: String) =
        User(this.name, surname)
}
```


```
val User.officialFullName: String
    get() = "$surname, $name"

fun User.withName(name: String) =
    User(name, this.surname)
```


```
fun randomStr(length: Int): String { // length is a parameter
    // ....
}

randomString(10) // 10 is an argument
randomString(10 + 20) // 30 is an argument
```


```
//1
inline fun <reified T> printName() { // T is a type parameter
    print(T::class.simpleName)
}

fun main() {
    printName<String>() // String is a type argument
}
```


```
class SomeObject {
    val text: String

    constructor(text: String) {
        this.text = text
        print("Creating object")
    }
}
```


```
class SomeObject(text: String) {
    val text: String = text

    init {
        print("Creating object")
    }
}
```


```
class SomeObject(val text: String) {
    init {
        print("Creating object")
    }
}
```


```
class SomeObject(val text: String) {
    constructor(date: Date) : this(date.toString())

    init {
        print("Creating object")
    }
}
```


```
class SomeObject @JvmOverloads constructor(
    val text: String = ""
) {
    init {
        print("Creating object")
    }
}
```