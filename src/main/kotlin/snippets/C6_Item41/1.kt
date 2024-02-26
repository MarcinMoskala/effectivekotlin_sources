package f_C6_Item41.s_1

import java.math.BigDecimal

enum class PaymentOption {
    CASH,
    CARD,
    TRANSFER;

    // Do not define mutable state in enum values
    var commission: BigDecimal = BigDecimal.ZERO
}

fun main() {
    val c1 = PaymentOption.CARD
    val c2 = PaymentOption.CARD
    print(c1 == c2) // true,
    // because it is the same object

    c1.commission = BigDecimal.TEN
    print(c2.commission) // 10
    // because c1 and c2 point to the same item

    val t = PaymentOption.TRANSFER
    print(t.commission) // 0,
    // because commission is per-item
}
