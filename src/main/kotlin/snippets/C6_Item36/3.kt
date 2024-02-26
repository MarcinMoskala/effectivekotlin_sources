package f_C6_Item36.s_3

class ProgressBar {
    fun show() { 
        /* show progress bar */
    }
    fun hide() { 
        /* hide progress bar */
    }
}

class ProfileLoader {
    val progressBar = ProgressBar()

    fun load() {
        progressBar.show()
        // load profile
        progressBar.hide()
    }
}

class ImageLoader {
    val progressBar = ProgressBar()

    fun load() {
        progressBar.show()
        // load image
        progressBar.hide()
    }
}
