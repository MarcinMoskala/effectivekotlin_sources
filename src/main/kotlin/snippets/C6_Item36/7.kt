package f_C6_Item36.s_7

class CounterSet<T> : HashSet<T>() {
    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return super.add(element)
    }
}
