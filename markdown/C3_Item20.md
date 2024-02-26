```
val percent = when {
  numberFromUser > 100 -> 100
  numberFromUser < 0 -> 0
  else -> numberFromUser
}
```


```
val percent = numberFromUser.coerceIn(0, 100)
```


```
override fun saveCallResult(item: SourceResponse) {
  var sourceList = ArrayList<SourceEntity>()
  item.sources.forEach {
      var sourceEntity = SourceEntity()
      sourceEntity.id = it.id
      sourceEntity.category = it.category
      sourceEntity.country = it.country
      sourceEntity.description = it.description
      sourceList.add(sourceEntity)
  }
  db.insertSources(sourceList)
}
```


```
override fun saveCallResult(item: SourceResponse) {
  val entries = item.sources.map(Source::toEntry)
  db.insertSources(entries)
}

private fun Source.toEntry() = SourceEntity().apply {
   id = this.id
   category = this.category
   country = this.country
   description = this.description
}
```


```
fun Iterable<Int>.product() =
     fold(1) { acc, i -> acc * i }
```