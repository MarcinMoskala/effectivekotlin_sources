```
//1
class User(var name: String, var surname: String)

val user = User("Marcin", "Moskała")
```


```
//2
data class Student(
    val name: String,
    val surname: String,
    val age: Int
)
```


```
class QuotationPresenter(
    private val view: QuotationView,
    private val repo: QuotationRepository
) {
    private var nextQuoteId = -1

    fun onStart() {
        onNext()
    }

    fun onNext() {
        nextQuoteId = (nextQuoteId + 1) % repo.quotesNumber
        val quote = repo.getQuote(nextQuoteId)
        view.showQuote(quote)
    }
}
```


```
//3
class Pizza {
    val size: String
    val cheese: Int
    val olives: Int
    val bacon: Int

    constructor(
        size: String,
        cheese: Int,
        olives: Int,
        bacon: Int
    ) {
        this.size = size
        this.cheese = cheese
        this.olives = olives
        this.bacon = bacon
    }

    constructor(
        size: String,
        cheese: Int,
        olives: Int
    ) : this(size, cheese, olives, 0)

    constructor(
        size: String,
        cheese: Int
    ) : this(size, cheese, 0)

    constructor(size: String) : this(size, 0)
}
```


```
//4
class Pizza(
    val size: String,
    val cheese: Int = 0,
    val olives: Int = 0,
    val bacon: Int = 0
)
```


```
val myFavorite = Pizza("L", olives = 3)
```


```
val myFavorite = Pizza("L", olives = 3, cheese = 1)
```


```
val villagePizza = Pizza("L", 1, 2, 3)
```


```
val villagePizza = Pizza(
    size = "L",
    cheese = 1,
    olives = 2,
    bacon = 3
)
```


```
//5
class Pizza private constructor(
    val size: String,
    val cheese: Int,
    val olives: Int,
    val bacon: Int
) {
    class Builder(private val size: String) {
        private var cheese: Int = 0
        private var olives: Int = 0
        private var bacon: Int = 0

        fun setCheese(value: Int): Builder {
            cheese = value
            return this
        }

        fun setOlives(value: Int): Builder {
            olives = value
            return this
        }

        fun setBacon(value: Int): Builder {
            bacon = value
            return this
        }

        fun build() = Pizza(size, cheese, olives, bacon)
    }
}
```


```
val myFavorite = Pizza.Builder("L").setOlives(3).build()

val villagePizza = Pizza.Builder("L")
    .setCheese(1)
    .setOlives(2)
    .setBacon(3)
    .build()
```


```
val villagePizza = Pizza(
    size = "L",
    cheese = 1,
    olives = 2,
    bacon = 3
)
```


```
val dialog = AlertDialog.Builder(context)
    .setMessage(R.string.fire_missiles)
    .setPositiveButton(R.string.fire) { d, id ->
        // FIRE MISSILES!
    }
    .setNegativeButton(R.string.cancel) { d, id ->
        // User cancelled the dialog
    }
    .create()

val router = Router.Builder()
    .addRoute(path = "/home", ::showHome)
    .addRoute(path = "/users", ::showUsers)
    .build()
```


```
val dialog = AlertDialog(
    context,
    message = R.string.fire_missiles,
    positiveButtonDescription =
    ButtonDescription(R.string.fire) { d, id ->
        // FIRE MISSILES!
    },
    negativeButtonDescription =
    ButtonDescription(R.string.cancel) { d, id ->
        // User cancelled the dialog
    }
)

val router = Router(
    routes = listOf(
        Route("/home", ::showHome),
        Route("/users", ::showUsers)
    )
)
```


```
val dialog = context.alert(R.string.fire_missiles) {
    positiveButton(R.string.fire) {
        // FIRE MISSILES!
    }
    negativeButton {
        // User cancelled the dialog
    }
}

val route = router {
    "/home" directsTo ::showHome
    "/users" directsTo ::showUsers
}
```


```
fun Context.makeDefaultDialogBuilder() =
    AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_dialog)
        .setTitle(R.string.dialog_title)
        .setOnCancelListener { it.cancel() }
```


```
data class DialogConfig(
    val icon: Int,
    val title: Int,
    val onCancelListener: (() -> Unit)?,
    //...
)

val defaultDialogConfig = DialogConfig(
    icon = R.drawable.ic_dialog,
    title = R.string.dialog_title,
    onCancelListener = { it.cancel() },
    //...
)

// or

fun defaultDialogConfig(
    val icon: Int = R.drawable.ic_dialog,
    val title: Int = R.string.dialog_title,
    val onCancelListener: (() -> Unit)? = { it.cancel() }
) = DialogConfig(icon, title, onCancelListener, /*...*/)
```