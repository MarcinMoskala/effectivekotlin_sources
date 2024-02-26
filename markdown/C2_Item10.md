```
// Implementation A
if (person != null && person.isAdult) {
  view.showPerson(person)
} else {
  view.showError()
}

// Implementation B
person?.takeIf { it.isAdult }
  ?.let(view::showPerson)
  ?: view.showError()
```


```
if (person != null && person.isAdult) {
  view.showPerson(person)
  view.hideProgressWithSuccess()
} else {
  view.showError()
  view.hideProgress()
}
```


```
person?.takeIf { it.isAdult }
  ?.let {
      view.showPerson(it)
      view.hideProgressWithSuccess()
  } ?: run {
      view.showError()
      view.hideProgress()
  }
```


```
class Person(val name: String)
var person: Person? = null

fun printName() {
   person?.let {
       print(it.name)
   }
}
```


```
students
    .filter { it.result >= 50 }  
    .joinToString(separator = "\n") {
       "${it.name} ${it.surname}, ${it.result}"
    }
    .let(::print)

var obj = FileInputStream("/file.gz")
   .let(::BufferedInputStream)
   .let(::ZipInputStream)
   .let(::ObjectInputStream)
   .readObject() as SomeObject
```


```
val abc = "A" { "B" } and "C"
print(abc) // ABC
```


```
operator fun String.invoke(f: ()->String): String =
   this + f()

infix fun String.and(s: String) = this + s
```