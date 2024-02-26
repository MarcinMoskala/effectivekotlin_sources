package f_C1_Item04.s_2

val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    var prime: Int
    while (true) {
        prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter { it % prime != 0 }
    }
}
