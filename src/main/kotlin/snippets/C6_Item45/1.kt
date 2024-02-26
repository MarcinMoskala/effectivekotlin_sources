package f_C6_Item45.s_1

open class C
class D : C()

fun C.foo() = "c"
fun D.foo() = "d"

fun main() {
   val d = D()
   print(d.foo()) // d
   val c: C = d
   print(c.foo()) // c

   print(D().foo()) // d
   print((D() as C).foo()) // c
}
