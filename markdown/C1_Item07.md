```
inline fun <reified T> String.readObjectOrNull(): T? {
    //...
    if (incorrectSign) {
        return null
    }
    //...
    return result
}

inline fun <reified T> String.readObject(): Result<T> {
    //...
    if (incorrectSign) {
        return Result.failure(JsonParsingException())
    }
    //...
    return Result.success(result)
}

class JsonParsingException : Exception()
```


```
userText.readObject<Person>()
    .onSuccess { showPersonAge(it) }
    .onFailure { showError(it) }
```


```
fun getA(): Result<T> = runCatching { getAThrowing() }
```


```
val age = userText.readObjectOrNull<Person>()?.age ?: -1

val printer: Printer? = getFirstAvailablePrinter()
printer?.print() // Safe call
if (printer != null) printer.print() // Smart casting
```