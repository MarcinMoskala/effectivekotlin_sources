package f_C4_Item29.s_2

class MutableLazyHolder<T>(val initializer: () -> T) {
   private var value: Any? = Any()
   private var initialized = false

   fun get(): T {
       if (!initialized) {
           value = initializer()
           initialized = true
       }
       return value as T
   }

   fun set(value: T) {
       this.value = value
       initialized = true
   }
}
