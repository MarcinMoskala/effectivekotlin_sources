package f_C7_Item52.s_4

interface User {
   fun decideAboutTime(): Int
   fun wakeUp()
}

interface Timer {
   fun callAfter(timeMillis: Int, callback: () -> Unit)
}

fun setUpUserWakeUpUser(user: User, timer: Timer) {
   val time: Int = user.decideAboutTime()
   timer.callAfter(time) {
       user.wakeUp()
   }
}
