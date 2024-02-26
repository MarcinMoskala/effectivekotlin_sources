package f_C2_Item14.s_7

@DslMarker
annotation class HtmlDsl

fun table(f: TableDsl.() -> Unit) { /*...*/ }

@HtmlDsl
class TableDsl { /*...*/ }
