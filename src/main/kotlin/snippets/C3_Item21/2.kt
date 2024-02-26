package f_C3_Item21.s_2

inline fun <T, R : Any> Iterable<T>.mapNotNull(
  transform: (T) -> R?
): List<R> {
  return mapNotNullTo(ArrayList<R>(), transform)
}
