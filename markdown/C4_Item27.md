```
@Experimental(level = Experimental.Level.WARNING)
annotation class ExperimentalNewApi

@ExperimentalNewApi
suspend fun getUsers(): List<User> {
  //...
}
```


```
@Deprecated("Use suspending getUsers instead")
fun getUsers(callback: (List<User>)->Unit) {
  //...
}
```


```
@Deprecated("Use suspending getUsers instead",
ReplaceWith("getUsers()"))
fun getUsers(callback: (List<User>)->Unit) {
  //...
}
```


```
@Deprecated("Use readBytes() overload without "+
"estimatedSize parameter",
ReplaceWith("readBytes()"))
public fun InputStream.readBytes(
  estimatedSize: Int = DEFAULT_BUFFER_SIZE
): ByteArray {
  //...
}
```