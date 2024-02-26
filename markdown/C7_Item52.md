```
@JvmInline
value class Name(private val value: String) {
    // ...
}
```


```
// Code
val name: Name = Name("Marcin")

// During compilation replaced with code similar to:
val name: String = "Marcin"
```


```
@JvmInline
value class Name(private val value: String) {
   // ...

   fun greet() {
       print("Hello, I am $value")
   }
}

// Code
val name: Name = Name("Marcin")
name.greet()

// During compilation replaced with code similar to:
val name: String = "Marcin"
Name.`greet-impl`(name)
```


```
interface Timer {
   fun callAfter(time: Int, callback: () -> Unit)
}
```


```
interface Timer {
   fun callAfter(timeMillis: Int, callback: () -> Unit)
}
```


```
interface User {
   fun decideAboutTime(): Int
   fun wakeUp()
}

interface Timer {
   fun callAfter(timeMillis: Int, callback: () -> Unit)
}

fun setUpUserWakeUpUser(user: User, timer: Timer) {
   val time: Int = user.decideAboutTime()
   timer.callAfter(time) {
       user.wakeUp()
   }
}
```


```
@JvmInline
value class Minutes(val minutes: Int) {
   fun toMillis(): Millis = Millis(minutes * 60 * 1000)
   // ...
}

@JvmInline
value class Millis(val milliseconds: Int) {
   // ...
}

interface User {
   fun decideAboutTime(): Minutes
   fun wakeUp()
}

interface Timer {
   fun callAfter(timeMillis: Millis, callback: () -> Unit)
}

fun setUpUserWakeUpUser(user: User, timer: Timer) {
   val time: Minutes = user.decideAboutTime()
   timer.callAfter(time) { // ERROR: Type mismatch
       user.wakeUp()
   }
}
```


```
fun setUpUserWakeUpUser(user: User, timer: Timer) {
   val time = user.decideAboutTime()
   timer.callAfter(time.toMillis()) {
       user.wakeUp()
   }
}
```


```
inline val Int.min
   get() = Minutes(this)

inline val Int.ms
   get() = Millis(this)

val timeMin: Minutes = 10.min
```


```
val time: Duration = 10.minutes
```


```
@JvmInline
value class StudentId(val value: String)

@JvmInline
value class ClassId(val value: String)

data class Student(val id: StudentId, val classId: ClassId)
```


```
@JvmInline
value class OptionalDouble(val value: Double) {
    
    fun isUndefined() = value.isNaN()
    
    companion object {
        const val UNDEFINED_VALUE = Double.NaN
        val Undefined = OptionalDouble(UNDEFINED_VALUE)
    }
}
```


```
interface TimeUnit {
   val millis: Long
}

@JvmInline
value class Minutes(val minutes: Long) : TimeUnit {
   override val millis: Long get() = minutes * 60 * 1000
   // ...
}

@JvmInline
value class Millis(val milliseconds: Long) : TimeUnit {
   override val millis: Long get() = milliseconds
}

// the type under the hood is TimeUnit
fun setUpTimer(time: TimeUnit) {
   val millis = time.millis
   //...
}

setUpTimer(Minutes(123))
setUpTimer(Millis(456789))
```


```
//1
@JvmInline
value class Millis(val milliseconds: Long) {
   val millis: Long get() = milliseconds
}

// the type under the hood is @Nullable Millis
fun setUpTimer(time: Millis?) {
   val millis = time?.millis
   //...
}

// the type under the hood is long
fun setUpTimer(time: Millis) {
   val millis = time.millis
   //...
}

fun main() {
   setUpTimer(Millis(456789))
}
```


```
typealias NewName = Int

val n: NewName = 10
```


```
typealias ClickListener =
   (view: View, event: Event) -> Unit

class View {
   fun addClickListener(listener: ClickListener) {}
   fun removeClickListener(listener: ClickListener) {}
   //...
}
```


```
//2
typealias Seconds = Int
typealias Millis = Int

fun getTime(): Millis = 10
fun setUpTimer(time: Seconds) {}

fun main() {
   val seconds: Seconds = 10
   val millis: Millis = seconds // No compiler error

   setUpTimer(getTime())
}
```