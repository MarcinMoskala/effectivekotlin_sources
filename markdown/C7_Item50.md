```
fun <T : Comparable<T>> Iterable<T>.countMax(): Int =
    count { it == this.maxOrNull() }
```


```
fun <T : Comparable<T>> Iterable<T>.countMax(): Int {
    val max = this.maxOrNull()
    return count { it == max }
}
```


```
fun String.isValidIpAddress(): Boolean {
    return this.matches(
        ("\\A(?:(?:25[0-5]|2[0-4][0-9]|" +
        "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|" +
        "[01]?[0-9][0-9]?)\\z").toRegex()
    )
}

// Usage
print("5.173.80.254".isValidIpAddress()) // true
```


```
private val IS_VALID_IP_REGEX = "\\A(?:(?:25[0-5]|2[0-4]" +
    "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|"+
    "[01]?[0-9][0-9]?)\\z".toRegex()

fun String.isValidIpAddress(): Boolean =
    matches(IS_VALID_IP_REGEX)
```


```
private val IS_VALID_IP_REGEX by lazy {
   ("\\A(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"+
   "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\z").toRegex()
}
```


```
class A {
    val b = B()
    val c = C()
    val d = D()

    //...
}
```


```
class A {
    val b by lazy { B() }
    val c by lazy { C() }
    val d by lazy { D() }

    //...
}
```