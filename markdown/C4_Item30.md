```
fun Context.showMessage(
   message: String,
   length: MessageLength = MessageLength.LONG
) {
  val toastLength = when(length) {
      SHORT -> Toast.LENGTH_SHORT
      LONG -> Toast.LENGTH_LONG
  }
  Toast.makeText(this, message, toastLength).show()
}

enum class MessageLength { SHORT, LONG }
```


```
/**
* Universal way for the project to display a short
* message to a user.
* @param message The text that should be shown to
* the user
* @param length How long to display the message.
*/
fun Context.showMessage(
   message: String,
   duration: MessageLength = MessageLength.LONG
) {
  val toastDuration = when(duration) {
      SHORT -> Toast.LENGTH_SHORT
      LONG -> Toast.LENGTH_LONG
  }
  Toast.makeText(this, message, toastDuration).show()
}

enum class MessageLength { SHORT, LONG }
```


```
//1
/**
* Powerset returns a set of all subsets of the receiver
* including itself and the empty set
*/
fun <T> Collection<T>.powerset(): Set<Set<T>> =
   if (isEmpty()) setOf(emptySet())
   else take(size - 1)
       .powerset()
       .let { it + it.map { it + last() } }
```


```
//2
/**
* Powerset returns a set of all subsets of the receiver
* including itself and empty set
*/
fun <T> Collection<T>.powerset(): Set<Set<T>> =
     powerset(this, setOf(setOf()))

private tailrec fun <T> powerset(
   left: Collection<T>,
   acc: Set<Set<T>>
): Set<Set<T>> = when {
  left.isEmpty() -> acc
  else -> {
     val head = left.first()
     val tail = left.drop(1)
     powerset(tail, acc + acc.map { it + head })
  }
}
```


```
//3
fun List<Int>.product() = fold(1) { acc, i -> acc * i }
```


```
//4
// Product of all numbers in a list
fun List<Int>.product() = fold(1) { acc, i -> acc * i }
```


```
fun update() {
  // Update users
  for (user in users) {
      user.update()
  }

  // Update books
  for (book in books) {
      updateBook(book)
  }
}
```


```
fun update() {
  updateUsers()
  updateBooks()
}

private fun updateBooks() {
  for (book in books) {
      updateBook(book)
  }
}

private fun updateUsers() {
  for (user in users) {
      user.update()
  }
}
```


```
/**
* Returns a new read-only list of given elements.
* The returned list is serializable (JVM).
* @sample samples.collections.Collections.Lists.
readOnlyList
*/
public fun <T> listOf(vararg elements: T): List<T> =
    if (elements.size > 0) elements.asList()
    else emptyList()
```


```
//5
/**
* This is an example descriptions linking to [element1],
* [com.package.SomeClass.element2] and
* [this element with custom description][element3]
*/
```


```
/**
* Immutable tree data structure.
*
* Class represents an immutable tree with from 1 to
* an infinite number of elements. In the tree we hold
* elements on each node, and nodes can have left and
* right subtrees...
*
* @param T the type of elements this tree holds.
* @property value the value kept in this node of the tree.
* @property left the left subtree.
* @property right the right subtree.
*/
class Tree<T>(
   val value: T,
   val left: Tree<T>? = null,
   val right: Tree<T>? = null
) {
   /**
   * Creates a new tree based on the current but with
   * [element] added.
   * @return newly created tree with additional element.
   */
   operator fun plus(element: T): Tree { ... }
}
```


```
interface Car {
  fun setWheelPosition(angle: Float)
  fun setBreakPedal(pressure: Double)
  fun setGasPedal(pressure: Double)
}

class GasolineCar: Car {
  // ...
}

class GasCar: Car {
  // ...
}

class ElectricCar: Car {
  // ...
}
```


```
//6
interface Car {
  /**
   * Changes car direction.
   *
   * @param angle Represents position of wheels in
   * radians relatively to car axis. 0 means driving
   * straight, pi/2 means driving maximally right,
   * -pi/2 maximally left.
   * Value needs to be in (-pi/2, pi/2)
   */
  fun setWheelPosition(angle: Float)

  /**
   * Decelerates vehicle speed until 0.
   *
   * @param pressure The percentage of brake pedal use.
   * Number from 0 to 1 where 0 means not using break
   * at all, and 1 means maximal pedal pedal use.
   */
  fun setBreakPedal(pressure: Double)

  /**
   * Accelerates vehicle speed until max speed possible
   * for the user.
   *
   * @param pressure The percentage of gas pedal use.
   * Number from 0 to 1 where 0 means not using gas at
   * all, and 1 means maximal gas pedal use.
   */
  fun setGasPedal(pressure: Double)
}
```