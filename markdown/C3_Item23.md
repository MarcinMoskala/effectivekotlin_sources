```
val ints: List<Int> = listOf(1, 2, 3)
val numbers: List<Number> = ints
```


```
interface List<out E> : Collection<E> {
  /*...*/
}

fun interface ReadOnlyProperty<in T, out V> {
    operator fun getValue(
        thisRef: T, 
        property: KProperty<*>
    ): V
}

interface Continuation<in T> {
    val context: CoroutineContext
    fun resumeWith(result: Result<T>)
}
```