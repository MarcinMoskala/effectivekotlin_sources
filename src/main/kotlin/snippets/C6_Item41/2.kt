package f_C6_Item41.s_2

import java.math.BigDecimal

enum class PaymentOption(val commission: BigDecimal) {
   CASH(BigDecimal.ONE),
   CARD(BigDecimal.TEN),
   TRANSFER(BigDecimal.ZERO)
}

fun main() {
   println(PaymentOption.CARD.commission) // 10
   println(PaymentOption.TRANSFER.commission) // 0

   val paymentOption: PaymentOption =
       PaymentOption.values().random()
   println(paymentOption.commission) // 0, 1 or 10
}
