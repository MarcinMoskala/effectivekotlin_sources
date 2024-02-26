package f_C7_Item52.s_6

@JvmInline
value class OptionalDouble(val value: Double) {
    
    fun isUndefined() = value.isNaN()
    
    companion object {
        const val UNDEFINED_VALUE = Double.NaN
        val Undefined = OptionalDouble(UNDEFINED_VALUE)
    }
}
