package f_C5_Item32.s_1

class LinkedList<T>(
    val head: T,
    val tail: LinkedList<T>?
)

val list = LinkedList(1, LinkedList(2, null))
