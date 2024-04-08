package f_C9__Dictionary.s_2

class IntWrapper(val i: Int) {
    fun doubled(): IntWrapper = IntWrapper(i * 2)
}

val wrapper = IntWrapper(10)
val doubledWrapper = wrapper.doubled()

val doubledReference = IntWrapper::doubled
