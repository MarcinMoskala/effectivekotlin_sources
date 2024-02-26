```
public inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

public inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    return mapTo(
        ArrayList<R>(collectionSizeOrDefault(10)),
        transform
    )
}

public inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}
```


```
repeat(10) {
   print(it)
}
```


```
for (index in 0 until 10) {
   print(index)
}
```


```
any is List<Int> // Error
any is List<*> // OK
```


```
fun <T> printTypeName() {
   print(T::class.simpleName) // ERROR
}
```


```
inline fun <reified T> printTypeName() {
   print(T::class.simpleName)
}

// Usage
printTypeName<Int>()    // Int
printTypeName<Char>()   // Char
printTypeName<String>() // String
```


```
print(Int::class.simpleName) // Int
print(Char::class.simpleName) // Char
print(String::class.simpleName) // String
```


```
//1
class Worker
class Manager

val employees: List<Any> =
   listOf(Worker(), Manager(), Worker())

val workers: List<Worker> =
   employees.filterIsInstance<Worker>()
```


```
inline fun <reified T : Any> String.fromJsonOrNull(): T? =
   try {
       gson.fromJson(json, T::class.java)
   } catch (e: JsonSyntaxException) {
       null
   }

// usage
val user: User? = userAsText.fromJsonOrNull()

// Koin module declaration
val myModule = module {
   single { Controller(get()) } // get is reified
   single { BusinessService() }
}

// Koin injection
val service: BusinessService by inject()
// inject is reified
```


```
//2
inline fun print(message: Any?) {
   System.out.print(message)
}
```


```
//3
class OnClickListener : () -> Unit {
   override fun invoke() {
       // ...
   }
}
```


```
//4
inline fun repeat(times: Int, action: (Int) -> Unit) {
   for (index in 0 until times) {
       action(index)
   }
}

fun repeatNoinline(times: Int, action: (Int) -> Unit) {
   for (index in 0 until times) {
       action(index)
   }
}
```


```
@Benchmark
// On average 189 ms
fun nothingInline(blackhole: Blackhole) {
   repeat(100_000_000) {
       blackhole.consume(it)
   }
}

@Benchmark
// On average 447 ms
fun nothingNoninline(blackhole: Blackhole) {
   noinlineRepeat(100_000_000) {
       blackhole.consume(it)
   }
}
```


```
users.filter { it.bought }.sumByDouble { it.price }
```


```
var l = 1L
noinlineRepeat(100_000_000) {
   l += it
}
```


```
val a = Ref.LongRef()
a.element = 1L
noinlineRepeat(100_000_000) {
   a.element = a.element + it
}
```


```
@Benchmark
// On average 30 ms
fun nothingInline(blackhole: Blackhole) {
   var l = 0L
   repeat(100_000_000) {
       l += it
   }
   blackhole.consume(l)
}

@Benchmark
// On average 274 ms
fun nothingNoninline(blackhole: Blackhole) {
   var l = 0L
   noinlineRepeat(100_000_000) {
       l += it
   }
   blackhole.consume(l)
}
```


```
if (value != null) {
   print(value)
}

for (i in 1..10) {
   print(i)
}

repeatNoninline(10) {
   print(it)
}
```


```
fun main() {
   noinlineRepeat(10) {
       print(it)
       return // ERROR: Not allowed
   }
}
```


```
//5
fun main() {
   repeat(10) {
       print(it)
       return // OK
   }
}
```


```
fun getSomeMoney(): Money? {
   repeat(100) {
       val money = searchForMoney()
       if (money != null) return money
   }
   return null
}
```


```
internal inline fun read() {
   val reader = Reader() // Error
   // ...
}

private class Reader {
   // ...
}
```


```
//6
inline fun a() {
   b()
}
inline fun b() {
   c()
}
inline fun c() {
   a()
}
```


```
//7
inline fun printThree() {
   print(3)
}
```


```
inline fun threePrintThree() {
   printThree()
   printThree()
   printThree()
}
```


```
inline fun threeThreePrintThree() {
   threePrintThree()
   threePrintThree()
   threePrintThree()
}

inline fun threeThreeThreePrintThree() {
   threeThreePrintThree()
   threeThreePrintThree()
   threeThreePrintThree()
}
```


```
//8
inline fun printThree() {
   print(3)
}

inline fun threePrintThree() {
   print(3)
   print(3)
   print(3)
}
```


```
//9
inline fun threeThreePrintThree() {
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
}

inline fun threeThreeThreePrintThree() {
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
   print(3)
}
```


```
//10
inline fun requestNewToken(
   hasToken: Boolean,
   crossinline onRefresh: () -> Unit,
   noinline onGenerate: () -> Unit
) {
   if (hasToken) {
       httpCall("get-token", onGenerate) // We must use
       // noinline to pass function as an argument to a
       // function that is not inlined
   } else {
       httpCall("refresh-token") {
           onRefresh() // We must use crossinline to
           // inline function in a context where
           // non-local return is not allowed
           onGenerate()
       }
   }
}

fun httpCall(url: String, callback: () -> Unit) {
   /*...*/
}
```