```
// Defining methods as members
class Workshop(/*...*/) {
    //...

    fun makeEvent(date: DateTime): Event = //...

    val permalink
        get() = "/workshop/$name"
}
```


```
// Defining methods as extensions
class Workshop(/*...*/) {
   //...
}

fun Workshop.makeEvent(date: DateTime): Event = //...

val Workshop.permalink
   get() = "/workshop/$name"
```


```
fun useWorkshop(workshop: Workshop) {
   val event = workshop.makeEvent(date)
   val permalink = workshop.permalink

   val makeEventRef = Workshop::makeEvent
   val permalinkPropRef = Workshop::permalink
}
```


```
//1
open class C
class D : C()

fun C.foo() = "c"
fun D.foo() = "d"

fun main() {
   val d = D()
   print(d.foo()) // d
   val c: C = d
   print(c.foo()) // c

   print(D().foo()) // d
   print((D() as C).foo()) // c
}
```


```
fun foo(`this$receiver`: C) = "c"
fun foo(`this$receiver`: D) = "d"

fun main() {
   val d = D()
   print(foo(d)) // d
   val c: C = d
   print(foo(c)) // c

   print(foo(D())) // d
   print(foo(D() as C)) // c
}
```


```
inline fun CharSequence?.isNullOrBlank(): Boolean {
   contract {
       returns(false) implies (this@isNullOrBlank != null)
   }

   return this == null || this.isBlank()
}

public fun Iterable<Int>.sum(): Int {
   var sum: Int = 0
   for (element in this) {
       sum += element
   }
   return sum
}
```


```
// Kotlin stdlib
interface Iterable<out T> {
    operator fun iterator(): Iterator<T>
}

public inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    // ...
}

public inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    // ...
}
```


```
fun ProductJson.toProduct() = Product(
    id = this.id,
    title = this.title,
    imgSrc = this.img,
    description = this.desc,
    price = BigDecimal(this.price),
    type = enumValueOf<ProductType>(this.type)
)

fun Product.toProductJson() = ProductJson(
    id = this.id,
    title = this.title,
    img = this.imgSrc,
    desc = this.description,
    price = this.price.toString(),
    type = this.type.name
)
```