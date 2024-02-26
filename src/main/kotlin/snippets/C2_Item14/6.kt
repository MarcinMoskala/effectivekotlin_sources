package f_C2_Item14.s_6

class Node(val name: String) {

   fun makeChild(childName: String) =
       create("$name.$childName").apply {
          print("Created ${this?.name} in "+
              " ${this@Node.name}")
       }

   fun create(name: String): Node? = Node(name)
}

fun main() {
   val node = Node("parent")
   node.makeChild("child")
   // Created parent.child in parent
}
