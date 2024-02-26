```
val visibleNews = mutableListOf<News>()
for (n in news) {
    if (n.visible) {
        visibleNews.add(n)
    }
}

Collections.sort(visibleNews,
    { n1, n2 -> n2.publishedAt - n1.publishedAt })
val newsItemAdapters = mutableListOf<NewsItemAdapter>()
for (n in visibleNews) {
    newsItemAdapters.add(NewsItemAdapter(n))
}
```


```
val newsItemAdapters = news
    .filter { it.visible }
    .sortedByDescending { it.publishedAt }
    .map(::NewsItemAdapter)
```


```
fun productsListProcessing(): String = 
    clientsList
        .filter { it.adult }
        .flatMap { it.products }
        .filter { it.bought }
        .map { it.price }
        .filterNotNull()
        .map { "$$it" }
        .joinToString(separator = " + ")

fun productsSequenceProcessing(): String =
    clientsList.asSequence()
        .filter { it.adult }
        .flatMap { it.products.asSequence() }
        .filter { it.bought }
        .mapNotNull { it.price }
        .joinToString(separator = " + ") { "$$it" }
```