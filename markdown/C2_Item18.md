```
class Person(
   val id: Int = 0,
   val name: String = "",
   val surname: String = ""
) : Human(id, name) {
   // body
}
```


```
public fun <T> Iterable<T>.joinToString(
   separator: CharSequence = ", ",
   prefix: CharSequence = "",
   postfix: CharSequence = "",
   limit: Int = -1,
   truncated: CharSequence = "...",
   transform: ((T) -> CharSequence)? = null
): String {
  // ...
}
```


```
// Don’t do that
class Person(val id: Int = 0,
             val name: String = "",
             val surname: String = "") : Human(id, name){
   // body
}
```