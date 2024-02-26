package f_C1_Item01.s_3

fun calculate(): Int {
    print("Calculating... ")
    return 42
}

val fizz = calculate() // Calculating...
val buzz
    get() = calculate()

fun main() {
    print(fizz) // 42
    print(fizz) // 42
    print(buzz) // Calculating... 42
    print(buzz) // Calculating... 42
}
