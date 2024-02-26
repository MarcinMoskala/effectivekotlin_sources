package f_C1_Item01.s_4

interface Element {
    val active: Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}
