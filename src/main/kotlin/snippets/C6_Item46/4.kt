package f_C6_Item46.s_4

class A {
   val a = 10
}
class B {
   val a = 20
   val b = 30

   fun A.test() = a + b // Is it 40 or 50?
}
