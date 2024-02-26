```
sealed interface BinaryTree
class Leaf(val value: Any?) : BinaryTree
class Node(val left: Tree, val right: Tree) : BinaryTree

sealed interface Either<out L, out R>
class Left<L>(val value: L) : Either<L, Nothing>
class Right<R>(val value: R) : Either<Nothing, R>
```


```
sealed class ValueChange<out T>
object Keep: ValueChange<Nothing>()
object SetDefault: ValueChange<Nothing>()
object SetEmpty: ValueChange<Nothing>()
class Set<out T>(val value: T): ValueChange<T>()

sealed class ManagerMessage
class CodeProduced(val code: String): ManagerMessage()
object ProductionStopped: ManagerMessage()

sealed interface AdView
object FacebookAd: AdView
object GoogleAd: AdView
class OwnAd(val text: String, val imgUrl: String): AdView
```


```
sealed class Response<out R>
class Success<R>(val value: R): Response<R>()
class Failure(val error: Throwable): Response<Nothing>()

fun handle(response: Response<String>) {
    val text = when (response) {
        is Success -> "Success with ${response.value}"
        is Failure -> "Error"
        // else is not needed here
    }
    print(text)
}
```