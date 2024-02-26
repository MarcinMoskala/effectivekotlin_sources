package f_C1_Item02.s_1

class Counter {
    private val lock = Any()
    private var num = 0
    
    fun inc() = synchronized(lock) {
        num += 1
    }
    
    fun dec() = synchronized(lock) {
        num -= 1
    }

    // Synchronization is not necessary; however,
    // without it, getter might serve stale value
    fun get(): Int = num
}
