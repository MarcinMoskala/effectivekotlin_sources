```
class Student(val name: String?)

// Works
fun List<Student>.getNames(): List<String> = this
    .map { it.name }
    .filter { it != null }
    .map { it!! }

// Better
fun List<Student>.getNames(): List<String> = this
    .map { it.name }
    .filterNotNull()

// Best
fun List<Student>.getNames(): List<String> = this
    .mapNotNull { it.name }
```