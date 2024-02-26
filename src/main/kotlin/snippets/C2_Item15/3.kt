package f_C2_Item15.s_3

open class Supercomputer {
  open val theAnswer: Long = 42
}

class AppleComputer : Supercomputer() {
  override val theAnswer: Long = 1_800_275_2273
}
