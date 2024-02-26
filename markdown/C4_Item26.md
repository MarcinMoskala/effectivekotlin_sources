```
fun isPasswordValid(text: String): Boolean {
  if(text.length < 7) return false
  //...
}
```


```
const val MIN_PASSWORD_LENGTH = 7

fun isPasswordValid(text: String): Boolean {
  if(text.length < MIN_PASSWORD_LENGTH) return false
  //...
}
```


```
//1
val MAX_THREADS = 10
```


```
Toast.makeText(this, message, Toast.LENGTH_LONG).show()
```


```
fun Context.toast(
  message: String,
  duration: Int = Toast.LENGTH_LONG
) {
  Toast.makeText(this, message, duration).show()
}

// Usage
context.toast(message)

// Usage in Activity or subclasses of Context
toast(message)
```


```
fun Context.snackbar(
  message: String,
  length: Int = Toast.LENGTH_LONG
) {
  //...
}
```


```
fun Context.snackbar(
  message: String,
  duration: Int = Snackbar.LENGTH_LONG
) {
  //...
}
```


```
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
class MessageDisplay(val context: Context) {

  fun show(
      message: String,
      duration: Length = Length.LONG
  ) {
      val toastDuration = when(duration) {
          SHORT -> Toast.LENGTH_SHORT
          LONG -> Toast.LENGTH_LONG
      }
      Toast.makeText(context, message, toastDuration)
           .show()
  }

  enum class Length { SHORT, LONG }
}

// Usage
val messageDisplay = MessageDisplay(context)
messageDisplay.show("Message")
```


```
@Inject 
lateinit var messageDisplay: MessageDisplay
```


```
val messageDisplay: MessageDisplay = mockk()
```


```
messageDisplay.setChristmasMode(true)
```


```
interface MessageDisplay {
  fun show(
      message: String,
      duration: Length = LONG
  )
}

class ToastDisplay(val context: Context): MessageDisplay {

  override fun show(
      message: String,
      duration: Length
  ) {
      val toastDuration = when(duration) {
          SHORT -> Toast.LENGTH_SHORT
          LONG -> Toast.LENGTH_LONG
      }
      Toast.makeText(context, message, toastDuration)
         .show()
  }

  enum class Length { SHORT, LONG }
}
```


```
val messageDisplay: MessageDisplay = TestMessageDisplay()
```


```
//2
var nextId: Int = 0

// Usage
val newId = nextId++
```


```
//3
private var nextId: Int = 0
fun getNextId(): Int = nextId++

// Usage
val newId = getNextId()
```


```
//4
data class Id(private val id: Int)

private var nextId: Int = 0
fun getNextId(): Id = Id(nextId++)
```