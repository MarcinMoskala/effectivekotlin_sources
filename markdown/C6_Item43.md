```
data class FullName(
   var name: String,
   var surname: String
)

val person = FullName("Maja", "Markiewicz")
val s = mutableSetOf<FullName>()
s.add(person)
person.surname = "Moskała"
print(person) // FullName(name=Maja, surname=Moskała)
print(s.contains(person)) // false
print(person in s) // false
print(s.first() == person) // true
```


```
class FullName(
   var name: String,
   var surname: String
) {
   override fun equals(other: Any?): Boolean =
       other is FullName
       && other.name == name
       && other.surname == surname
}

val s = mutableSetOf<FullName>()
s.add(FullName("Marcin", "Moskała"))
val p = FullName("Marcin", "Moskała")
print(p in s) // false
print(p == s.first()) // true
```


```
class Proper(val name: String) {

    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Proper && name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        var equalsCounter = 0
    }
}

class Terrible(val name: String) {
    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Terrible && name == other.name
    }

    // Terrible choice, DO NOT DO THAT
    override fun hashCode() = 0

    companion object {
        var equalsCounter = 0
    }
}

val properSet = List(10000) { Proper("$it") }.toSet()
println(Proper.equalsCounter) // 0
val terribleSet = List(10000) { Terrible("$it") }.toSet()
println(Terrible.equalsCounter) // 50116683

Proper.equalsCounter = 0
println(Proper("9999") in properSet) // true
println(Proper.equalsCounter) // 1

Proper.equalsCounter = 0
println(Proper("A") in properSet) // false
println(Proper.equalsCounter) // 0

Terrible.equalsCounter = 0
println(Terrible("9999") in terribleSet) // true
println(Terrible.equalsCounter) // 4324

Terrible.equalsCounter = 0
println(Terrible("A") in terribleSet) // false
println(Terrible.equalsCounter) // 10001
```


```
class DateTime(
   private var millis: Long = 0L,
   private var timeZone: TimeZone? = null
) {
   private var asStringCache = ""
   private var changed = false

   override fun equals(other: Any?): Boolean =
       other is DateTime &&
       other.millis == millis &&
       other.timeZone == timeZone

   override fun hashCode(): Int {
       var result = millis.hashCode()
       result = result * 31 + timeZone.hashCode()
       return result
   }
}
```


```
override fun hashCode(): Int =
   Objects.hash(timeZone, millis)
```


```
override fun hashCode(): Int =
   hashCodeFrom(timeZone, millis)

inline fun hashCodeOf(vararg values: Any?) =
   values.fold(0) { acc, value ->
       (acc * 31) + value.hashCode()
   }
```


```
data class DateTime2(
   private var millis: Long = 0L,
   private var timeZone: TimeZone? = null
) {
   private var asStringCache = ""
   private var changed = false
}
```