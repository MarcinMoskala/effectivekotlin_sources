```
obj1 > obj2 // translates to obj1.compareTo(obj2) > 0
obj1 < obj2 // translates to obj1.compareTo(obj2) < 0
obj1 >= obj2 // translates to obj1.compareTo(obj2) >= 0
obj1 <= obj2 // translates to obj1.compareTo(obj2) <= 0
```


```
//1
class User(val name: String, val surname: String)

val names = listOf<User>(/*...*/)

val sorted = names.sortedBy { it.surname }
```


```
val sorted = names
    .sortedWith(compareBy({ it.surname }, { it.name }))
```


```
// DON'T DO THIS!
print("Kotlin" > "Java") // true
```


```
class User(val name: String, val surname: String) {
   // ...

   companion object {
       val DISPLAY_ORDER =
           compareBy(User::surname, User::name)
   }
}

val sorted = names.sortedWith(User.DISPLAY_ORDER)
```


```
//2
class User(
   val name: String,
   val surname: String
) : Comparable<User> {
   override fun compareTo(other: User): Int =
       compareValues(surname, other.surname)
}
```


```
//3
class User(
    val name: String,
    val surname: String
) : Comparable<User> {
    override fun compareTo(other: User): Int =
        compareValuesBy(this, other,
            { it.surname },
            { it.name }
        )
}
```