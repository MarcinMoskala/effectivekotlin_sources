package f_C4_Item30.s_1

/**
* Powerset returns a set of all subsets of the receiver
* including itself and the empty set
*/
fun <T> Collection<T>.powerset(): Set<Set<T>> =
   if (isEmpty()) setOf(emptySet())
   else take(size - 1)
       .powerset()
       .let { it + it.map { it + last() } }
