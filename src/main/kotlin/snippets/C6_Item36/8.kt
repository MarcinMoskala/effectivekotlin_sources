package f_C6_Item36.s_8

class CounterSet<T> : MutableSet<T> {
    private val innerSet = HashSet<T>()
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }

    override val size: Int
        get() = innerSet.size

    override fun contains(element: T): Boolean =
        innerSet.contains(element)

    override fun containsAll(elements: Collection<T>):
    Boolean = innerSet.containsAll(elements)

    override fun isEmpty(): Boolean = innerSet.isEmpty()

    override fun iterator() =
        innerSet.iterator()

    override fun clear() =
        innerSet.clear()

    override fun remove(element: T): Boolean =
        innerSet.remove(element)

    override fun removeAll(elements: Collection<T>):
    Boolean = innerSet.removeAll(elements)

    override fun retainAll(elements: Collection<T>):
    Boolean = innerSet.retainAll(elements)
}
