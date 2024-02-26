package f_C5_Item32.s_2

fun main() {
    val seq1 = sequence<Int> {
        repeat(10) {
            print(it)
            yield(10)
        }
    }
    seq1.asSequence() // Nothing printed
    seq1.toList() // Prints 0123456789


    val l1 = mutableListOf(1, 2, 3, 4)
    val l2 = l1.toList()
    val seq2 = l1.asSequence()
    l1.add(5)
    println(l2) // Prints [1, 2, 3, 4]
    println(seq2.toList()) // Prints [1, 2, 3, 4, 5]
}
