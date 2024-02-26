```
enum class PaymentOption {
    CASH,
    CARD,
    TRANSFER
}
```


```
//1
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
```


```
//2
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
```


```
enum class PaymentOption {
    CASH {
        override fun startPayment(
            transaction: Transaction
        ) {
            showCashPaymentInfo(transaction)
        }
    },
    CARD {
        override fun startPayment(
            transaction: Transaction
        ) {
            moveToCardPaymentPage(transaction)
        }
    },
    TRANSFER {
        override fun startPayment(
            transaction: Transaction
        ) {
            showMoneyTransferInfo()
            setupPaymentWatcher(transaction)
        }
    };

    abstract fun startPayment(transaction: Transaction)
}
```


```
enum class PaymentOption(
   val startPayment: (Transaction) -> Unit
) {
   CASH(::showCashPaymentInfo),
   CARD(::moveToCardPaymentPage),
   TRANSFER({
       showMoneyTransferInfo()
       setupPaymentWatcher(it)
   })
}
```


```
enum class PaymentOption {
   CASH,
   CARD,
   TRANSFER
}

fun PaymentOption.startPayment(transaction: Transaction) {
   when (this) {
       CASH -> showCashPaymentInfo(transaction)
       CARD -> moveToCardPaymentPage(transaction)
       TRANSFER -> {
           showMoneyTransferInfo()
           setupPaymentWatcher(transaction)
       }
   }
}
```


```
//3
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
```


```
sealed class PaymentOption
object Cash : PaymentOption()
object Card : PaymentOption()
object Transfer : PaymentOption()
```


```
sealed class ManagerMessage()
object ProductionStarted : ManagerMessage()
object ProductionStopped : ManagerMessage()

// In the future me might add something like this:
class Alert(val message: String) : ManagerMessage()

// or we might need to add data to an existing message
class ProductionStarted(
   val time: DateTime
) : ManagerMessage()
```


```
sealed class Payment

data class CashPayment(
    val amount: BigDecimal,
    val pointId: Int
) : Payment()


data class CardPayment(
    val amount: BigDecimal,
    val pointId: Int
) : Payment()


data class BankTransfer(
    val amount: BigDecimal,
    val pointId: Int
) : Payment()

fun process(payment: Payment) {
    when (payment) {
        is CashPayment -> {
            showPaymentInfo(
                payment.amount,
                payment.pointId
            )
        }
        is CardPayment -> {
            moveToCardPaiment(
                payment.amount,
                payment.orderId
            )
        }
        is BankTransfer -> {
            val transferRepo = BankTransferRepo()
            val transferDetails = transferRepo.getDetails()
            displayTransferInfo(
                payment.amount,
                transferDetails
            )
            transferRepo.setUpPaymentWathcher(
                payment.orderId,
                payment.amount,
                transferDetails
            )
        }
    }
}
```