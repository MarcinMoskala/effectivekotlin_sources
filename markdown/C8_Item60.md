```
class InvoiceService {
    private val invoices = ArrayDeque<Invoice>()
    
    fun addInvoice(invoice: Invoice) = synchronized(this) {
        invoices.addLast(invoice)
    }
    
    fun processInvoices() = synchronized(this) {
        while (invoices.isNotEmpty()) {
            val invoice = invoices.removeFirst()
            // ...
        }
    }
}
```


```
class LinkedList<T> : List<T> {
    private val head: Node<T>? = null


    private class Node<T>(
        val value: T, 
        var next: Node<T>?
    )
    
    // ...
}
```


```
fun deserialize(input: ByteReadPacket): LeadersMessage {
    val size = input.readInt()
    val leaders = HashMap<City, User>(size)
    repeat(size) {
        val city = deserializeCity(input)
        val user = deserializeUser(input)
        leaders[city] = user
    }
    return LeadersMessage(leaders)
}
```


```
//1
class BinaryTree<T : Comparable<T>> {
    private val root: Node<T>? = null
    
    private class Node<T>(
        val value: T, 
        var left: Node<T>?, 
        var right: Node<T>?
    )

    // ...
}
```


```
val sortedSet = sortedSetOf(5, 1, 3, 2, 4)
println(sortedSet) // [1, 2, 3, 4, 5]

val sortedMap = sortedMapOf(
    5 to "five",
    1 to "one",
    3 to "three",
    2 to "two",
    4 to "four"
)
println(sortedMap) // {1=one, 2=two, 3=three, 4=four, 5=five}
```


```
class ArticlesListAdapter {
    private val articles = sortedSetOf(ARTICLES_COMPARATOR)
    
    fun add(article: Article) {
        articles.add(article)
        redrawView()
    }
    
    private fun redrawView() {
        // ...
    }

    companion object {
        val ARTICLES_COMPARATOR: Comparator<Article> =
            compareByDescending { it.publishedDate }
    }
}
```