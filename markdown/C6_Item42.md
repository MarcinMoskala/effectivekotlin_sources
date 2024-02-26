```
open class Animal
class Book
Animal() == Book()  // Error: Operator == cannot be
// applied to Animal and Book
Animal() === Book() // Error: Operator === cannot be
// applied to Animal and Book
```


```
class Cat : Animal()
Animal() == Cat()  // OK, because Cat is a subclass of
// Animal
Animal() === Cat() // OK, because Cat is a subclass of
// Animal
```


```
class Name(val name: String)

val name1 = Name("Marcin")
val name2 = Name("Marcin")
val name1Ref = name1

name1 == name1 // true
name1 == name2 // false
name1 == name1Ref // true

name1 === name1 // true
name1 === name2 // false
name1 === name1Ref // true
```


```
data class FullName(val name: String, val surname: String)

val name1 = FullName("Marcin", "Moskała")
val name2 = FullName("Marcin", "Moskała")
val name3 = FullName("Maja", "Moskała")

name1 == name1 // true
name1 == name2 // true, because data are the same
name1 == name3 // false

name1 === name1 // true
name1 === name2 // false
name1 === name3 // false
```


```
class DateTime(
    /** The millis from 1970-01-01T00:00:00Z */
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
) {
    private var asStringCache = ""
    private var changed = false

    override fun equals(other: Any?): Boolean =
        other is DateTime &&
                other.millis == millis &&
                other.timeZone == timeZone

    //...
}
```


```
data class DateTime(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
) {
    private var asStringCache = ""
    private var changed = false

    //...
}
```


```
class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    override fun equals(other: Any?): Boolean =
        other is User && other.id == id

    override fun hashCode(): Int = id
}
```


```
// DO NOT DO THIS!
class Time(
    val millisArg: Long = -1,
    val isNow: Boolean = false
) {
    val millis: Long
        get() =
            if (isNow) System.currentTimeMillis()
            else millisArg

    override fun equals(other: Any?): Boolean =
        other is Time && millis == other.millis
}

val now = Time(isNow = true)
now == now // Sometimes true, sometimes false
List(100000) { now }.all { it == now }
// Most likely false
```


```
val now1 = Time(isNow = true)
val now2 = Time(isNow = true)
assertEquals(now1, now2)
// Sometimes passes, sometimes not
```


```
sealed class Time
data class TimePoint(val millis: Long) : Time()
object Now : Time()
```


```
class Complex(
    val real: Double,
    val imaginary: Double
) {
    // DO NOT DO THIS, violates symmetry
    override fun equals(other: Any?): Boolean {
        if (other is Double) {
            return imaginary == 0.0 && real == other
        }
        return other is Complex &&
                real == other.real &&
                imaginary == other.imaginary
    }
}
```


```
Complex(1.0, 0.0).equals(1.0) // true
1.0.equals(Complex(1.0, 0.0)) // false
```


```
val list = listOf<Any>(Complex(1.0, 0.0))
list.contains(1.0) // Currently on the JVM this is false,
// but it depends on the collection’s implementation
// and should not be trusted to stay the same
```


```
Complex(1.0, 0.0) == 1.0 // ERROR
```


```
open class Date(
    val year: Int,
    val month: Int,
    val day: Int
) {
    // DO NOT DO THIS, symmetric but not transitive
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> this == o.date
        is Date -> o.day == day &&
                o.month == month &&
                o.year == year
        else -> false
    }

    // ...
}

class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
) : Date(date.year, date.month, date.day) {
    // DO NOT DO THIS, symmetric but not transitive
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> o.date == date &&
                o.hour == hour &&
                o.minute == minute &&
                o.second == second
        is Date -> date == o
        else -> false
    }

    // ...
}
```


```
val o1 = DateTime(Date(1992, 10, 20), 12, 30, 0)
val o2 = Date(1992, 10, 20)
val o3 = DateTime(Date(1992, 10, 20), 14, 45, 30)

o1 == o2 // true
o2 == o3 // true
o1 == o3 // false, so equality is not transitive

setOf(o2, o1, o3).size // 1 or 2? 
// Depends on the collection’s implementation
```


```
data class Date(
    val year: Int,
    val month: Int,
    val day: Int
)

data class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
)

val o1 = DateTime(Date(1992, 10, 20), 12, 30, 0)
val o2 = Date(1992, 10, 20)
val o3 = DateTime(Date(1992, 10, 20), 14, 45, 30)

o1.equals(o2) // false
o2.equals(o3) // false
o1 == o3 // false

o1.date.equals(o2) // true
o2.equals(o3.date) // true
o1.date == o3.date // true
```


```
//1
import java.net.URL

fun main() {
    val enWiki = URL("https://en.wikipedia.org/")
    val wiki = URL("https://wikipedia.org/")
    println(enWiki == wiki)
}
```


```
override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is MyClass) return false
    return field1 == other.field1 &&
            field2 == other.field2 &&
            field3 == other.field3
}
// or
override fun equals(other: Any?) =
    this === other ||
    (other is MyClass &&
    field1 == other.field1 &&
    field2 == other.field2 &&
    field3 == other.field3)
```