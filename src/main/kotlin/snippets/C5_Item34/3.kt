package f_C5_Item34.s_3

class Dialog {
    var title: String = ""
    var text: String = ""
    fun show() { /*...*/
    }
}

fun showDialog(init: Dialog.() -> Unit) {
    val dialog = Dialog()
    init.invoke(dialog)
    dialog.show()
}

fun main() {
    showDialog {
        title = "My dialog"
        text = "Some text"
    }
}
