package f_C7_Item48.s_3

sealed interface StoreMessage<out T>
data class Save<T>(val data: T) : StoreMessage<T>
data object DeleteAll : StoreMessage<Nothing>
