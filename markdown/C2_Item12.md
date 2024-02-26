```
val netPrice = BigDecimal("10")
val tax = BigDecimal("0.23")
val currentBalance = BigDecimal("20")
val newBalance = currentBalance - netPrice * tax
println(newBalance) // 17.70
```


```
val now = ZonedDateTime.now()
val duration = Duration.ofDays(1)
val sameTimeTomorrow = now + duration
```


```
val newBalance = currentBalance.minus(netPrice.times(tax))
val sameTimeTomorrow = now.plus(duration)
```


```
val now = LocalDateTime.now()
val start = LocalDate.parse("2021-10-17").atStartOfDay()
val end = LocalDate.parse("2021-10-21").atStartOfDay()
if(now > start) { /*...*/ }
if(now < end) { /*...*/ }
if(now in start..end) { /*...*/ }

val price = BigDecimal("100.00")
val minPrice = BigDecimal("10.00")
val maxPrice = BigDecimal("1000.00")
if(price > minPrice) { /*...*/ }
if(price < maxPrice) { /*...*/ }
if(price in minPrice..maxPrice) { /*...*/ }
```


```
if(now.isAfter(start)) { /*...*/ }
if(now.isBefore(end)) { /*...*/ }
if(!now.isBefore(start) && !now.isAfter(end)) { /*...*/ }

if(price.compareTo(minPrice) > 0) { /*...*/ }
if(price.compareTo(maxPrice) < 0) { /*...*/ }
if(minPrice.compareTo(price) <= 0 &&
   price.compareTo(maxPrice) <= 0) { /*...*/ }
```


```
val num1 = BigDecimal("1.0")
val num2 = BigDecimal("1.00")
println(num1 == num2) // false
println(num1 >= num2 && num1 <= num2) // true
```


```
val SUPPORTED_TAGS = setOf("ADMIN", "TRAINER", "ATTENDEE")
val tag = "ATTENDEE"

println(SUPPORTED_TAGS.contains(tag)) // true
// or
println(tag in SUPPORTED_TAGS) // true
```


```
val ADMIN_TAG = "ADMIN"
val admins = users.map { user.tags.contains(ADMIN_TAG) }
// or
val admins = users.map { ADMIN_TAG in user.tags }
```


```
@JvmInline
value class Centimeter(private val value: Double) {
   operator fun plus(other: Centimeter): Centimeter =
       Centimeter(value + other.value)

   operator fun plus(other: Millimeter): Centimeter =
       Centimeter(value + other.value * 10)
  
   // ...
}
```