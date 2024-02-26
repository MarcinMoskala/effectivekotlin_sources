package f_C6_Item42.s_3

class Complex(
    val real: Double,
    val imaginary: Double
) {
    // DO NOT DO THIS, violates symmetry
    override fun equals(other: Any?): Boolean {
        if (other is Double) {
            return imaginary == 0.0 && real == other
        }
        return other is Complex &&
                real == other.real &&
                imaginary == other.imaginary
    }
}
