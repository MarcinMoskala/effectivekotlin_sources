package f_C5_Item34.s_12

class TdBuilder {
    var text = ""

    operator fun String.unaryPlus() {
        text += this
    }
}
