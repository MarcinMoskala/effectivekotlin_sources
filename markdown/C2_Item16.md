```
fun keyIsCorrect(key: String): Boolean = //...

if(!keyIsCorrect(key)) return
```


```
fun verifyKey(key: String): Unit? = //...

verifyKey(key) ?: return
```


```
getData()
    ?.let { view.showData(it) } 
    ?: view.showError()
```


```
if (person != null && person.isAdult) {
   view.showPerson(person)
} else {
   view.showError()
}
```


```
if(!keyIsCorrect(key)) return

verifyKey(key) ?: return
```