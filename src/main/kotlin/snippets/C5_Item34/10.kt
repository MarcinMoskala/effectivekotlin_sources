package f_C5_Item34.s_10

class Dialog {
    var title: String = ""
    var text: String = ""
    fun show() { /*...*/
    }
}

fun main() {
    val dialog = Dialog()
    val init: Dialog.() -> Unit = {
        title = "My dialog"
        text = "Some text"
    }
    init.invoke(dialog)
    dialog.show()
}
