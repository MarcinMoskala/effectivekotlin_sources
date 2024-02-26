```
// Count the number of users in each city
val usersCount: Map<City, Int> = users
    .groupBy { it.city }
    .mapValues { (_, users) -> users.size }

// Find the number of points received by each team
val pointsPerTeam: Map<Team, Int> = players
    .groupBy { it.team }
    .mapValues { (_, players) ->
        players.sumOf { it.points }
    }

// Find the best option in each category
val bestFormatPerQuality: Map<Quality, Resolution> =
    formats.groupBy { it.quality }
        .mapValues { (_, formats) ->
            formats.maxByOrNull { it.resolution }!!
            // it is fine to use !! here, because
            // this collection cannot be empty
        }
```


```
public inline fun <T, K> Iterable<T>.groupingBy(
    crossinline keySelector: (T) -> K
): Grouping<T, K> {
    return object : Grouping<T, K> {
        override fun sourceIterator(): Iterator<T> =
            this@groupingBy.iterator()
        override fun keyOf(element: T): K =
            keySelector(element)
    }
}
```


```
val usersCount = users.groupingBy { it.city }
    .eachCount()
```


```
val pointsPerTeam = players
    .groupingBy { it.team }
    .fold(0) { acc, elem -> acc + elem.points }
```


```
fun <T, K> Grouping<T, K>.eachSumBy(
    selector: (T) -> Int
): Map<K, Int> =
    fold(0) { acc, elem -> acc + selector(elem) }

val pointsPerTeam = players
    .groupingBy { it.team }
    .eachSumBy { it.points }
```


```
val bestFormatPerQuality = formats
    .groupingBy { it.quality }
    .reduce { _, acc, elem ->
        if (acc.resolution > elem.resolution) acc else elem
    }
```


```
// Could be optimized to keep accumulator selector
inline fun <T, K> Grouping<T, K>.eachMaxBy(
    selector: (T) -> Int
): Map<K, T> =
    reduce { _, acc, elem ->
        if (selector(acc) > selector(elem)) acc else elem
    }

val bestFormatPerQuality = formats
    .groupingBy { it.quality }
    .eachMaxBy { it.resolution }
```


```
val bestFormatPerQuality = formats
    .groupingBy { it.quality }
    .aggregate { _, acc: VideoFormat?, elem: VideoFormat, _ ->
        when {
            acc == null -> elem
            acc.resolution > elem.resolution -> acc
            else -> elem
        }
    }
```