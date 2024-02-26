```
//1
object Singleton {
    fun doSomething() {
        // ...
    }
}

fun main() {
    val obj = Singleton
    obj.doSomething()

    Singleton.doSomething()
}
```


```
sealed class ValueChange<out T>
data object Keep : ValueChange<Nothing>()
data object SetDefault : ValueChange<Nothing>()
data object SetEmpty : ValueChange<Nothing>()
data class Set<out T>(val value: T) : ValueChange<T>()


sealed class ManagerMessage
data class CodeProduced(val code: String) : ManagerMessage()
data object ProductionStopped : ManagerMessage()


sealed interface AdView
data object FacebookAd : AdView
data object GoogleAd : AdView
data class OwnAd(val text: String,val imgUrl: String):AdView
```


```
sealed interface StoreMessage<T>
data class Save<T>(val data: T) : StoreMessage<T>
data class DeleteAll<T> : StoreMessage<T>
```


```
sealed interface StoreMessage<out T>
data class Save<T>(val data: T) : StoreMessage<T>
data object DeleteAll : StoreMessage<Nothing>
```


```
val deleteAllInt: StoreMessage<Int> = DeleteAll
val deleteAllString: StoreMessage<String> = DeleteAll
```


```
internal object EmptyList : List<Nothing> {
    // ...
}

val emptyListInt: List<Int> = EmptyList
val emptyListString: List<String> = EmptyList
```