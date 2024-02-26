```
fun Int.factorial(): Int = (1..this).product()

fun Iterable<Int>.product(): Int =
   fold(1) { acc, i -> acc * i }
```


```
print(10 * 6.factorial()) // 7200
```


```
operator fun Int.not() = factorial()

print(10 * !6) // 7200
```


```
print(10 * 6.not()) // 7200
```


```
val path = Path("A")
val path2 = path / "B"
println(path2) // Prints: A/B
```


```
val path = Path("A")
val path2 = path.div("B")
println(path2) // Prints: A/B
```


```
operator fun Int.times(operation: () -> Unit): ()->Unit =
   { repeat(this) { operation() } }

val tripledHello = 3 * { print("Hello") }

tripledHello() // Prints: HelloHelloHello
```


```
operator fun Int.times(operation: () -> Unit) {
    repeat(this) { operation() }
}

3 * { print("Hello") } // Prints: HelloHelloHello
```


```
infix fun Int.timesRepeated(operation: () -> Unit) = {
    repeat(this) { operation() }
}

val tripledHello = 3 timesRepeated { print("Hello") }
tripledHello() // Prints: HelloHelloHello
```


```
repeat(3) { print("Hello") } // Prints: HelloHelloHello
```


```
body {
    div {
        +"Some text"
    }
}
```