package f_C4_Item26.s_4

data class Id(private val id: Int)

private var nextId: Int = 0
fun getNextId(): Id = Id(nextId++)
