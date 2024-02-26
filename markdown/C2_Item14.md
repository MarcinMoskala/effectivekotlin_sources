```
class User: Person() {
  private var beersDrunk: Int = 0

  fun drinkBeers(num: Int) {
      // ...
      this.beersDrunk += num
      // ...
  }
}
```


```
fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
  if (size < 2) return this
  val pivot = first()
  val (smaller, bigger) = drop(1)
      .partition { it < pivot }
  return smaller.quickSort() + pivot + bigger.quickSort()
}
```


```
fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
  if (this.size < 2) return this
  val pivot = this.first()
  val (smaller, bigger) = this.drop(1)
      .partition { it < pivot }
  return smaller.quickSort() + pivot + bigger.quickSort()
}
```


```
listOf(3, 2, 5, 1, 6).quickSort() // [1, 2, 3, 5, 6]
listOf("C", "D", "A", "B").quickSort() // [A, B, C, D]
```


```
//1
class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
          .apply { print("Created ${name}") }

  fun create(name: String): Node? = Node(name)
}

fun main() {
  val node = Node("parent")
  node.makeChild("child")
}
```


```
class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
        .apply { print("Created ${this.name}") }
        // Compilation error

  fun create(name: String): Node? = Node(name)
}        
```


```
//2
class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
          .apply { print("Created ${this?.name}") }

  fun create(name: String): Node? = Node(name)
}

fun main() {
   val node = Node("parent")
   node.makeChild("child")
   // Prints: Created parent.child
}
```


```
class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
          .also { print("Created ${it?.name}") }

  fun create(name: String): Node? = Node(name)
}
```


```
//3
class Node(val name: String) {

   fun makeChild(childName: String) =
       create("$name.$childName").apply {
          print("Created ${this?.name} in "+
              " ${this@Node.name}")
       }

   fun create(name: String): Node? = Node(name)
}

fun main() {
   val node = Node("parent")
   node.makeChild("child")
   // Created parent.child in parent
}
```


```
table {
  tr {
      td { +"Column 1" }
      td { +"Column 2" }
  }
  tr {
      td { +"Value 1" }
      td { +"Value 2" }
  }
}
```


```
table {
  tr {
      td { +"Column 1" }
      td { +"Column 2" }
      tr {
          td { +"Value 1" }
          td { +"Value 2" }
     }
  }
}
```


```
@DslMarker
annotation class HtmlDsl

fun table(f: TableDsl.() -> Unit) { /*...*/ }

@HtmlDsl
class TableDsl { /*...*/ }
```


```
table {
  tr {
      td { +"Column 1" }
      td { +"Column 2" }
      tr { // COMPILATION ERROR
          td { +"Value 1" }
          td { +"Value 2" }
      }
  }
}
```


```
table {
  tr {
      td { +"Column 1" }
      td { +"Column 2" }
      this@table.tr {
          td { +"Value 1" }
          td { +"Value 2" }
      }
  }
}
```