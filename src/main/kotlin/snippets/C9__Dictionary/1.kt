package f_C9__Dictionary.s_1

inline fun <reified T> printName() { // T is a type parameter
    print(T::class.simpleName)
}

fun main() {
    printName<String>() // String is a type argument
}
