package f_C7_Item51.s_4

inline fun repeat(times: Int, action: (Int) -> Unit) {
   for (index in 0 until times) {
       action(index)
   }
}

fun repeatNoinline(times: Int, action: (Int) -> Unit) {
   for (index in 0 until times) {
       action(index)
   }
}
