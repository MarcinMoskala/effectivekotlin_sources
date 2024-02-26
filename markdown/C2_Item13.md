```
//1
val num = 10
val name = "Marcin"
val ids = listOf(12, 112, 554, 997)
```


```
val data = getSomeData()
```


```
val data: UserData = getSomeData()
```


```
open class Animal
class Bear : Animal()
class Camel : Animal()

fun main() {
    var animal = Bear()
    animal = Camel() // Error: Type mismatch
}
```


```
interface CarFactory {
    fun produce(): Car
}
```


```
val DEFAULT_CAR: Car = Fiat126P()
```


```
interface CarFactory {
    fun produce() = DEFAULT_CAR
}
```


```
val DEFAULT_CAR = Fiat126P()
```


```
kotlin {
    // ...
    
    // for strict mode
    explicitApi()
    
    // for warning mode
    explicitApiWarning()
}
```