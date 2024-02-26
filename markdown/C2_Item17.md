```
val text = (1..10).joinToString("|")
```


```
val text = (1..10).joinToString(separator = "|")
```


```
val separator = "|"
val text = (1..10).joinToString(separator)
```


```
val separator = "|"
val text = (1..10).joinToString(separator = separator)
```


```
sleep(100)
```


```
sleep(timeMillis = 100)
```


```
sleep(Millis(100))
```


```
sleep(100.milliseconds)
```


```
fun sendEmail(to: String, message: String) {
    /*...*/
}
```


```
sendEmail(
    to = "contact@kt.academy",
    message = "Hello, ..."
)
```


```
thread {
    // ...
}
```


```
val view = linearLayout {
    text("Click below")
    button({ /* 1 */ }, { /* 2 */ })
}
```


```
val view = linearLayout {
    text("Click below")
    button(onClick = { /* 1 */ }) {
        /* 2 */
    }
}
```


```
fun call(before: () -> Unit = {}, after: () -> Unit = {}) {
    before()
    print("Middle")
    after()
}

call({ print("CALL") }) // CALLMiddle
call { print("CALL") }  // MiddleCALL
```


```
call(before = { print("CALL") }) // CALLMiddle
call(after = { print("CALL") })  // MiddleCALL
```


```
observable.getUsers()
    .subscribeBy(
        onNext = { users: List<User> ->
            // ...
        },
        onError = { throwable: Throwable ->
            // ...
        },
        onCompleted = {
            // ...
        }
    )
```