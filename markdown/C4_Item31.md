```
class Employee {
  private val id: Int = 2
  override fun toString() = "User(id=$id)"

  private fun privateFunction() {
      println("Private function called")
  }
}

fun callPrivateFunction(employee: Employee) {
  employee::class.declaredMemberFunctions
       .first { it.name == "privateFunction" }
       .apply { isAccessible = true }
       .call(employee)
}

fun changeEmployeeId(employee: Employee, newId: Int) {
  employee::class.java.getDeclaredField("id")
       .apply { isAccessible = true }
       .set(employee, newId)
}

fun main() {
  val employee = Employee()
  callPrivateFunction(employee)
  // Prints: Private function called

  changeEmployeeId(employee, 1)
  print(employee) // Prints: User(id=1)
}
```


```
class Id(val id: Int) {
  override fun equals(other: Any?) =
      other is Id && other.id == id
}

val mutableSet = mutableSetOf(Id(1))
mutableSet.add(Id(1))
mutableSet.add(Id(1))
print(mutableSet.size) // 3
```