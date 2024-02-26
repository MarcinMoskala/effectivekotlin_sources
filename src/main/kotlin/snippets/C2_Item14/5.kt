package f_C2_Item14.s_5

class Node(val name: String) {

  fun makeChild(childName: String) =
      create("$name.$childName")
          .also { print("Created ${it?.name}") }

  fun create(name: String): Node? = Node(name)
}
