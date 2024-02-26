```
// Kotlin property
var name: String? = null

// Java field
String name = null;
```


```
var name: String? = null
  get() = field?.toUpperCase()
  set(value) {
      if(!value.isNullOrBlank()) {
          field = value
      }
  }
```


```
val fullName: String
  get() = "$name $surname"
```


```
var date: Date
  get() = Date(millis)
  set(value) {
      millis = value.time
  }
```


```
interface Person {
  val name: String
}
```


```
open class Supercomputer {
  open val theAnswer: Long = 42
}

class AppleComputer : Supercomputer() {
  override val theAnswer: Long = 1_800_275_2273
}
```


```
val db: Database by lazy { connectToDb() }
```


```
val Context.preferences: SharedPreferences
  get() = PreferenceManager
      .getDefaultSharedPreferences(this)

val Context.inflater: LayoutInflater
  get() = getSystemService(
      Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

val Context.notificationManager: NotificationManager
  get() = getSystemService(Context.NOTIFICATION_SERVICE)
      as NotificationManager
```


```
// DON’T DO THIS!
val Tree<Int>.sum: Int
  get() = when (this) {
      is Leaf -> value
      is Node -> left.sum + right.sum
  }
```


```
fun Tree<Int>.sum(): Int = when (this) {
  is Leaf -> value
  is Node -> left.sum() + right.sum()
}
```


```
val s = (1..100).sum()
```


```
// DON’T DO THIS!
class UserIncorrect {
  private var name: String = ""

  fun getName() = name

  fun setName(name: String) {
      this.name = name
  }
}

class UserCorrect {
  var name: String = ""
}
```