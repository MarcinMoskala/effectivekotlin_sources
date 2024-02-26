```
fun String.isPhoneNumber(): Boolean =
    length == 7 && all { it.isDigit() }
```


```
fun isPhoneNumber(`$this`: String): Boolean =
   `$this`.length == 7 && `$this`.all { it.isDigit() }
```


```
interface PhoneBook {
   fun String.isPhoneNumber(): Boolean
}

class Fizz : PhoneBook {
   override fun String.isPhoneNumber(): Boolean =
       this.length == 7 && this.all { it.isDigit() }
}
```


```
class PhoneBookIncorrect {

   fun verify(number: String): Boolean {
       require(number.isPhoneNumber())
       // ...
   }

   // Bad practice, do not do this
   fun String.isPhoneNumber(): Boolean =
       this.length == 7 && this.all { it.isDigit() }
}
```


```
PhoneBookIncorrect().apply {
   "1234567890".isPhoneNumber()
}
```


```
class PhoneBook {

    fun verify(number: String): Boolean {
        require(number.isPhoneNumber())
        // ...
    }

    // ...
}

// This is how we limit extension functions visibility
private fun String.isPhoneNumber(): Boolean =
    this.length == 7 && this.all { it.isDigit() }
```


```
class PhoneBook(
    private val phoneNumberVerifier: PhoneNumberVerifier
) {

    fun verify(number: String): Boolean {
        require(number.let(::isPhoneNumber))
        // ...
    }

    // ...

    private fun isPhoneNumber(number: String): Boolean =
        phoneNumberVerifier.verify(number)
}
```


```
val ref = String::isPhoneNumber
val str = "1234567890"
val boundedRef = str::isPhoneNumber

val refX = PhoneBookIncorrect::isPhoneNumber // ERROR
val book = PhoneBookIncorrect()
val boundedRefX = book::isPhoneNumber // ERROR
```


```
class A {
   val a = 10
}
class B {
   val a = 20
   val b = 30

   fun A.test() = a + b // Is it 40 or 50?
}
```


```
class A {
   //...
}
class B {
   //...

   fun A.update() ... // Does it update A or B?
}
```


```
class OrderUseCase(
    // ...
) {
    // ...

    private fun CoroutineScope.produceOrders() =
        produce<Order> {
            var page = 0
            do {
                val orders = api
                    .requestOrders(page = page++)
                    .orEmpty()
                for (order in orders) send(order)
            } while (orders.isNotEmpty())
        }
}

interface UserApiTrait {

    fun TestApplicationEngine.requestRegisterUser(
        token: String,
        request: RegisterUserRequest
    ): UserJson? = ...

    fun TestApplicationEngine.requestGetUserSelf(
        token: String
    ): UserJson? = ...

    // ...
}
```