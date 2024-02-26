package f_C6_Item41.s_4

enum class PaymentOption {
    CASH,
    CARD,
    TRANSFER
}

inline fun <reified T : Enum<T>> printEnumValues() {
    for (value in enumValues<T>()) {
        println(value)
    }
}

fun main() {
    val options = PaymentOption.values()
    println(options.map { it.name })
    // [CASH, CARD, TRANSFER]

    val options2: Array<PaymentOption> =
        enumValues<PaymentOption>()
    println(options2.map { it.name })
    // [CASH, CARD, TRANSFER]

    val option: PaymentOption =
        PaymentOption.valueOf("CARD")
    println(option) // CARD

    val option2: PaymentOption =
        enumValueOf<PaymentOption>("CARD")
    println(option2) // CARD

    printEnumValues<PaymentOption>()
    // CASH
    // CARD
    // TRANSFER
}
