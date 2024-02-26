```
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator
.getObjectSize

fun main() {
    val ints = List(1_000_000) { it }
    val array: Array<Int> = ints.toTypedArray()
    val intArray: IntArray = ints.toIntArray()
    println(getObjectSize(ints))     // 20 000 040
    println(getObjectSize(array))    // 20 000 016
    println(getObjectSize(intArray)) //  4 000 016
}
```


```
open class InlineFilterBenchmark {

    lateinit var list: List<Int>
    lateinit var array: IntArray

    @Setup
    fun init() {
        list = List(1_000_000) { it }
        array = IntArray(1_000_000) { it }
    }

    @Benchmark
    // On average 1 260 593 ns
    fun averageOnIntList(): Double {
        return list.average()
    }

    @Benchmark
    // On average 868 509 ns
    fun averageOnIntArray(): Double {
        return array.average()
    }
}
```