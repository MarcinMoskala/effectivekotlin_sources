```
//1
class Forest(val name: String) {

  fun addTree(name: String) {
      // ...
  }
}
```


```
//2
interface Tree
class Birch: Tree
class Spruce: Tree

class Forest<T: Tree> {

  fun <T: Tree> addTree(tree: T) {
      // ...
  }
}
```


```
val forest = Forest<Birch>()
forest.addTree(Birch())
forest.addTree(Spruce())
```


```
class Forest<T: Tree> {

  fun addTree(tree: T) {
      // ...
  }
}

// Usage
val forest = Forest<Birch>()
forest.addTree(Birch())
forest.addTree(Spruce()) // ERROR, type mismatch
```


```
class Forest<T: Tree> {

  fun <ST: T> addTree(tree: ST) {
      // ...
  }
}
```