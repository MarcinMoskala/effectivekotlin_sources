package f_C2_Item10.s_1

class Person(val name: String)
var person: Person? = null

fun printName() {
   person?.let {
       print(it.name)
   }
}
