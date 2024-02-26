```
//1
class CoffeeMachine {

  fun makeCoffee() {
      // Declarations of hundreds of variables
      // Complex logic to coordinate everything
      // with many low-level optimizations
  }
}
```


```
//2
class CoffeeMachine {

  fun makeCoffee() {
      boilWater()
      brewCoffee()
      pourCoffee()
      pourMilk()
  }

  private fun boilWater() {
      // ...
  }

  private fun brewCoffee() {
      // ...
  }

  private fun pourCoffee() {
      // ...
  }

  private fun pourMilk() {
      // ...
  }
}
```


```
fun makeEspressoCoffee() {
    boilWater()
    brewCoffee()
    pourCoffee()
}
```