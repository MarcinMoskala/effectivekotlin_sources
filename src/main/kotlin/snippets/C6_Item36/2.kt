package f_C6_Item36.s_2

abstract class LoaderWithProgressBar {

    fun load() {
        // show progress bar
        action()
        // hide progress bar
    }

    abstract fun action()
}

class ProfileLoader : LoaderWithProgressBar() {

    override fun action() {
        // load profile
    }
}

class ImageLoader : LoaderWithProgressBar() {

    override fun action() {
        // load image
    }
}
