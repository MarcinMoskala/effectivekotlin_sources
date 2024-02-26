package f_C3_Item21.s_1

inline fun <T> Iterable<T>.filter(
   predicate: (T) -> Boolean
): List<T> {
   val destination = ArrayList<T>()
   for (element in this) {
       if (predicate(element)) {
          destination.add(element)
       }
   }
   return destination  
}
