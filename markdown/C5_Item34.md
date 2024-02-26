```
body {
    div {
        a("https://kotlinlang.org") {
            target = ATarget.blank
            +"Main site"
        }
    }
    +"Some content"
}
```


```
verticalLayout {
    val name = editText()
    button("Say Hello") {
        onClick { toast("Hello, ${name.text}!") }
    }
}
```


```
class HelloWorld : View() {
    override val root = hbox {
        label("Hello world") {
            addClass(heading)
        }

        textfield {
            promptText = "Enter your name"
        }
    }
}
```


```
fun Routing.api() {
    route("news") {
        get {
            val newsData = NewsUseCase.getAcceptedNews()
            call.respond(newsData)
        }
        get("propositions") {
            requireSecret()
            val newsData = NewsUseCase.getPropositions()
            call.respond(newsData)
        }
    }
    // ...
}
```


```
class MyTests : StringSpec({
    "length should return size of string" {
        "hello".length shouldBe 5
    }
    "startsWith should test for a prefix" {
        "world" should startWith("wor")
    }
})
```


```
plugins {
    `java-library`
}

dependencies {
    api("junit:junit:4.12")
    implementation("junit:junit:4.12")
    testImplementation("junit:junit:4.12")
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

sourceSets {
    main {
        java.srcDir("src/core/java")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    test {
        testLogging.showExceptions = true
    }
}
```


```
//1
inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    val list = arrayListOf<T>()
    for (elem in this) {
        if (predicate(elem)) {
            list.add(elem)
        }
    }
    return list
}
```


```
//2
fun plus(a: Int, b: Int) = a + b
```


```
//3
val plus1: (Int, Int) -> Int = { a, b -> a + b }
val plus2: (Int, Int) -> Int = fun(a, b) = a + b
val plus3: (Int, Int) -> Int = Int::plus
```


```
//4
val plus4 = { a: Int, b: Int -> a + b }
val plus5 = fun(a: Int, b: Int) = a + b
```


```
//5
fun Int.myPlus(other: Int) = this + other
```


```
//6
val myPlus = fun Int.(other: Int) = this + other
```


```
//7
val myPlus: Int.(Int) -> Int =
    fun Int.(other: Int) = this + other
```


```
//8
val myPlus: Int.(Int) -> Int = { this + it }
```


```
myPlus.invoke(1, 2)
myPlus(1, 2)
1.myPlus(2)
```


```
//9
class Dialog {
    var title: String = ""
    var text: String = ""
    fun show() { /*...*/ }
}

fun main() {
    val dialog = Dialog()
    dialog.title = "My dialog"
    dialog.text = "Some text"
    dialog.show()
}
```


```
//10
class Dialog {
    var title: String = ""
    var text: String = ""
    fun show() { /*...*/
    }
}

fun main() {
    val dialog = Dialog()
    val init: Dialog.() -> Unit = {
        title = "My dialog"
        text = "Some text"
    }
    init.invoke(dialog)
    dialog.show()
}
```


```
//11
class Dialog {
    var title: String = ""
    var text: String = ""
    fun show() { /*...*/
    }
}

fun showDialog(init: Dialog.() -> Unit) {
    val dialog = Dialog()
    init.invoke(dialog)
    dialog.show()
}

fun main() {
    showDialog {
        title = "My dialog"
        text = "Some text"
    }
}
```


```
inline fun <T> T.apply(block: T.() -> Unit): T {
    this.block()
    return this
}

Dialog().apply {
    title = "My dialog"
    text = "Some text"
}.show()
```


```
fun createTable(): TableBuilder = table {
    tr {
        for (i in 1..2) {
            td {
                +"This is column $i"
            }
        }
    }
}
```


```
fun table(init: TableBuilder.() -> Unit): TableBuilder {
    //...
}

class TableBuilder {
    fun tr(init: TrBuilder.() -> Unit) { /*...*/ }
}

class TrBuilder {
    fun td(init: TdBuilder.() -> Unit) { /*...*/ }
}

class TdBuilder
```


```
+"This is row $i"
```


```
//12
class TdBuilder {
    var text = ""

    operator fun String.unaryPlus() {
        text += this
    }
}
```


```
fun table(init: TableBuilder.() -> Unit): TableBuilder {
    val tableBuilder = TableBuilder()
    init.invoke(tableBuilder)
    return tableBuilder
}
```


```
fun table(init: TableBuilder.() -> Unit) =
    TableBuilder().apply(init)
```


```
class TableBuilder {
    var trs = listOf<TrBuilder>()

    fun tr(init: TrBuilder.() -> Unit) {
        trs = trs + TrBuilder().apply(init)
    }
}

class TrBuilder {
    var tds = listOf<TdBuilder>()

    fun td(init: TdBuilder.() -> Unit) {
        tds = tds + TdBuilder().apply(init)
    }
}
```