package f_C7_Item52.s_3

interface Timer {
   fun callAfter(timeMillis: Int, callback: () -> Unit)
}
