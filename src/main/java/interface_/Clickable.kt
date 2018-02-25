package interface_

/**
 * Created by zhaoyu on 2017/6/1.
 */
interface Clickable {
    fun click()
    fun showOff() = println("clickable!")       // 类似 default
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("focusable!")       // 类似 default
}

class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() {
        println("clicked!")
    }
}

fun main(args: Array<String>) {
    val btn = Button()
    btn.showOff()
    btn.setFocus(true)
    btn.click()
}