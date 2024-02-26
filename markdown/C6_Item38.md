```
interface OnClick {
    fun onClick(view: View)
}
```


```
fun setOnClickListener(listener: OnClick) {
    //...
}

setOnClickListener(object : OnClick {
    override fun onClick(view: View) {
        // ...
    }
})
```


```
// Function type usage
fun setOnClickListener(listener: (View) -> Unit) {
    //...
}

// Functional interface declaration
fun interface OnClick {
    fun onClick(view: View)
}

// Functional interface usage
fun setOnClickListener(listener: OnClick) {
    //...
}
```


```
setOnClickListener { /*...*/ }
setOnClickListener(fun(view) { /*...*/ })
```


```
setOnClickListener(::println)
setOnClickListener(this::showUsers)
```


```
class ClickListener : (View) -> Unit {
    override fun invoke(view: View) {
        // ...
    }
}

setOnClickListener(ClickListener())
```


```
typealias OnClick = (View) -> Unit
```


```
typealias OnClick<T> = (T) -> Unit
```


```
typealias OnClick = (view: View) -> Unit

fun setOnClickListener(listener: OnClick) { /*...*/ }
```


```
interface SwipeListener {
    fun onSwipe()
}

fun interface FlingListener {
    fun onFling()
}

fun setOnClickListener(listener: SwipeListener) {
    // when swipe happens
    listener.onSwipe()
}

fun main() {
    val onSwipe = SwipeListener { println("Swiped") }
    setOnClickListener(onSwipe) // Swiped

    val onFling = FlingListener { println("Touched") }
    setOnClickListener(onFling) // Error: Type mismatch
}
```


```
interface ElementListener<T> {
    fun invoke(element: T)
}

fun interface OnClick : ElementListener<View> {
    fun onClick(view: View)

    override fun invoke(element: View) {
        onClick(element)
    }
}
```


```
// Kotlin
class CalendarView() {
    var onDateClicked: ((date: Date) -> Unit)? = null
    var onPageChanged: OnDateClicked? = null
}

fun interface OnDateClicked {
    fun onClick(date: Date)
}
```


```
class CalendarView {
    var listener: Listener? = null

    interface Listener {
        fun onDateClicked(date: Date)
        fun onPageChanged(date: Date)
    }
}
```


```
// Using functional interfaces
class CalendarView {
    var onDateClicked: OnDateClicked? = null
    var onPageChanged: OnPageClicked? = null
}

// Using function types
class CalendarView {
    var onDateClicked: ((date: Date) -> Unit)? = null
    var onPageChanged: ((date: Date) -> Unit)? = null
}
```