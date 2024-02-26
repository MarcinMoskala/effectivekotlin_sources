package f_C7_Item51.s_1

class Worker
class Manager

val employees: List<Any> =
   listOf(Worker(), Manager(), Worker())

val workers: List<Worker> =
   employees.filterIsInstance<Worker>()
