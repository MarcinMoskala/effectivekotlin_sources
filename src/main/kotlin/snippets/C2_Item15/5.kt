package f_C2_Item15.s_5

// DON’T DO THIS!
class UserIncorrect {
  private var name: String = ""

  fun getName() = name

  fun setName(name: String) {
      this.name = name
  }
}

class UserCorrect {
  var name: String = ""
}
