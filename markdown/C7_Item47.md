```
val str1 = "Lorem ipsum dolor sit amet"
val str2 = "Lorem ipsum dolor sit amet"
print(str1 == str2) // true
print(str1 === str2) // true
```


```
val i1: Int? = 1
val i2: Int? = 1
print(i1 == i2) // true
print(i1 === i2) // true, because i2 was taken from cache
```


```
val j1: Int? = 1234
val j2: Int? = 1234
print(j1 == j2) // true
print(j1 === j2) // false
```


```
class A

private val a = A()

// Benchmark result: 2.698 ns/op
fun accessA(blackhole: Blackhole) {
    blackhole.consume(a)
}

// Benchmark result: 3.814 ns/op
fun createA(blackhole: Blackhole) {
    blackhole.consume(A())
}

// Benchmark result: 3828.540 ns/op
fun createListAccessA(blackhole: Blackhole) {
    blackhole.consume(List(1000) { a })
}

// Benchmark result: 5322.857 ns/op
fun createListCreateA(blackhole: Blackhole) {
    blackhole.consume(List(1000) { A() })
}
```


```
class Snapshot(
    var afterHours: SessionDetails,
    var preMarket: SessionDetails,
    var regularHours: SessionDetails,
)

data class SessionDetails(
    val open: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val close: Double? = null,
    val volume: Long? = null,
    val dollarVolume: Double? = null,
    val trades: Int? = null,
    val last: Double? = null,
    val time: Int? = null,
)
```


```
data class SessionDetails(
    val open: Double = Double.NaN,
    val high: Double = Double.NaN,
    val low: Double = Double.NaN,
    val close: Double = Double.NaN,
    val volume: Long = -1L,
    val dollarVolume: Double = Double.NaN,
    val trades: Int = -1,
    val last: Double = Double.NaN,
    val time: Int = -1,
)
```