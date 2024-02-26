package f_C6_Item46.s_3

interface PhoneBook {
   fun String.isPhoneNumber(): Boolean
}

class Fizz : PhoneBook {
   override fun String.isPhoneNumber(): Boolean =
       this.length == 7 && this.all { it.isDigit() }
}
