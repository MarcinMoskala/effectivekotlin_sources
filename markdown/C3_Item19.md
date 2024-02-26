```
class Student {
  // ...

  fun isPassing(): Boolean =
      calculatePointsFromPassedCourses() > 15

  fun qualifiesForScholarship(): Boolean =
      calculatePointsFromPassedCourses() > 30

  private fun calculatePointsFromPassedCourses(): Int {
      //...
  }
}
```


```
// scholarship module
fun Student.qualifiesForScholarship(): Boolean {
   /*...*/
}

// accreditations module
fun Student.calculatePointsFromPassedCourses(): Boolean {
   /*...*/
}
```