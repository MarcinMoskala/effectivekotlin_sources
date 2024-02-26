package f_C2_Item15.s_1

var name: String? = null
  get() = field?.toUpperCase()
  set(value) {
      if(!value.isNullOrBlank()) {
          field = value
      }
  }
