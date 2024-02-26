package f_C3_Item22.s_2

interface Tree
class Birch: Tree
class Spruce: Tree

class Forest<T: Tree> {

  fun <T: Tree> addTree(tree: T) {
      // ...
  }
}
