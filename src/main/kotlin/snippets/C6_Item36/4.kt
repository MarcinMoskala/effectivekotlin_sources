package f_C6_Item36.s_4

abstract class InternetLoader(val showAlert: Boolean) {

    fun load() {
        // show progress bar
        innerLoad()
        // hide progress bar
        if (showAlert) {
            // show alert
        }
    }

    abstract fun innerLoad()
}

class ProfileLoader : InternetLoader(showAlert = true) {

    override fun innerLoad() {
        // load profile
    }
}

class ImageLoader : InternetLoader(showAlert = false) {

    override fun innerLoad() {
        // load image
    }
}
