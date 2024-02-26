```
Picasso.get()
    .load(url)
    .into(imageView)
```


```
fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}
```


```
fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}
```