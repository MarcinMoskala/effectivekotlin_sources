```
inline fun <T> Iterable<T>.filter(
   predicate: (T) -> Boolean
): List<T> {
   val destination = ArrayList<T>()
   for (element in this) {
       if (predicate(element)) {
          destination.add(element)
       }
   }
   return destination  
}
```


```
fun <T : Comparable<T>> Iterable<T>.sorted(): List<T> {
  /*...*/
}

fun <T, C : MutableCollection<in T>>
Iterable<T>.toCollection(destination: C): C {
  /*...*/
}

class ListAdapter<T: ItemAdaper>(/*...*/) { /*...*/ }
```


```
inline fun <T, R : Any> Iterable<T>.mapNotNull(
  transform: (T) -> R?
): List<R> {
  return mapNotNullTo(ArrayList<R>(), transform)
}
```


```
fun <T: Animal> pet(animal: T) where T: GoodTempered {
  /*...*/
}

// OR

fun <T> pet(animal: T) where T: Animal, T: GoodTempered {
  /*...*/
}
```