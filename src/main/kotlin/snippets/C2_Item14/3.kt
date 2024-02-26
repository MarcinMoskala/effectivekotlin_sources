package f_C2_Item14.s_3

class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
          .apply { print("Created ${name}") }

  fun create(name: String): Node? = Node(name)
}

fun main() {
  val node = Node("parent")
  node.makeChild("child")
}
