package f_C8_Item60.s_1

class BinaryTree<T : Comparable<T>> {
    private val root: Node<T>? = null
    
    private class Node<T>(
        val value: T, 
        var left: Node<T>?, 
        var right: Node<T>?
    )

    // ...
}
