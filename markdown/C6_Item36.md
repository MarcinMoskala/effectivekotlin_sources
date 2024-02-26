```
class ProfileLoader {

    fun load() {
        // show progress bar
        // load profile
        // hide progress bar
    }
}

class ImageLoader {

    fun load() {
        // show progress bar
        // load image
        // hide progress bar
    }
}
```


```
abstract class LoaderWithProgressBar {

    fun load() {
        // show progress bar
        action()
        // hide progress bar
    }

    abstract fun action()
}

class ProfileLoader : LoaderWithProgressBar() {

    override fun action() {
        // load profile
    }
}

class ImageLoader : LoaderWithProgressBar() {

    override fun action() {
        // load image
    }
}
```


```
class ProgressBar {
    fun show() { 
        /* show progress bar */
    }
    fun hide() { 
        /* hide progress bar */
    }
}

class ProfileLoader {
    val progressBar = ProgressBar()

    fun load() {
        progressBar.show()
        // load profile
        progressBar.hide()
    }
}

class ImageLoader {
    val progressBar = ProgressBar()

    fun load() {
        progressBar.show()
        // load image
        progressBar.hide()
    }
}
```


```
class ImageLoader {
    private val progressBar = ProgressBar()
    private val finishedAlert = FinishedAlert()

    fun load() {
        progressBar.show()
        // load image
        progressBar.hide()
        finishedAlert.show()
    }
}
```


```
abstract class InternetLoader(val showAlert: Boolean) {

    fun load() {
        // show progress bar
        innerLoad()
        // hide progress bar
        if (showAlert) {
            // show alert
        }
    }

    abstract fun innerLoad()
}

class ProfileLoader : InternetLoader(showAlert = true) {

    override fun innerLoad() {
        // load profile
    }
}

class ImageLoader : InternetLoader(showAlert = false) {

    override fun innerLoad() {
        // load image
    }
}
```


```
abstract class Dog {
    open fun bark() {
        /*...*/
    }
    open fun sniff() { 
        /*...*/
    }
}
```


```
class Labrador : Dog()

class RobotDog : Dog() {
    override fun sniff() {
        error("Operation not supported")
        // Do you really want that?
    }
}
```


```
abstract class Robot {
    open fun calculate() { 
        /*...*/
    }
}

class RobotDog : Dog(), Robot() // Error
```


```
class CounterSet<T> : HashSet<T>() {
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return super.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return super.addAll(elements)
    }
}
```


```
val counterList = CounterSet<String>()
counterList.addAll(listOf("A", "B", "C"))
print(counterList.elementsAdded) // 6
```


```
class CounterSet<T> : HashSet<T>() {
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return super.add(element)
    }
}
```


```
class CounterSet<T> {
    private val innerSet = HashSet<T>()
    var elementsAdded: Int = 0
        private set

    fun add(element: T) {
        elementsAdded++
        innerSet.add(element)
    }

    fun addAll(elements: Collection<T>) {
        elementsAdded += elements.size
        innerSet.addAll(elements)
    }
}

val counterList = CounterSet<String>()
counterList.addAll(listOf("A", "B", "C"))
print(counterList.elementsAdded) // 3
```


```
class CounterSet<T> : MutableSet<T> {
    private val innerSet = HashSet<T>()
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }

    override val size: Int
        get() = innerSet.size

    override fun contains(element: T): Boolean =
        innerSet.contains(element)

    override fun containsAll(elements: Collection<T>):
    Boolean = innerSet.containsAll(elements)

    override fun isEmpty(): Boolean = innerSet.isEmpty()

    override fun iterator() =
        innerSet.iterator()

    override fun clear() =
        innerSet.clear()

    override fun remove(element: T): Boolean =
        innerSet.remove(element)

    override fun removeAll(elements: Collection<T>):
    Boolean = innerSet.removeAll(elements)

    override fun retainAll(elements: Collection<T>):
    Boolean = innerSet.retainAll(elements)
}
```


```
class CounterSet<T>(
    private val innerSet: MutableSet<T> = mutableSetOf()
) : MutableSet<T> by innerSet {

    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }
}
```


```
open class Parent {
    fun a() {}
    open fun b() {}
}

class Child : Parent() {
    override fun a() {} // Error
    override fun b() {}
}
```


```
open class ProfileLoader : InternetLoader() {

    final override fun load() {
        // load profile
    }
}
```