package f_C2_Item14.s_2

fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
  if (this.size < 2) return this
  val pivot = this.first()
  val (smaller, bigger) = this.drop(1)
      .partition { it < pivot }
  return smaller.quickSort() + pivot + bigger.quickSort()
}
