package f_C8_Item54.s_1

import java.math.BigDecimal

val fibonacci: Sequence<BigDecimal> = sequence {
    var current = 1.toBigDecimal()
    var prev = 1.toBigDecimal()
    yield(prev)
    while (true) {
        yield(current)
        val temp = prev
        prev = current
        current += temp
    }
}

fun main() {
    print(fibonacci.take(10).toList())
    // [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
}
