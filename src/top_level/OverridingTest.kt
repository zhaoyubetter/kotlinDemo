
package top_level

/**
 * 扩展函数 不能 Overriding
 * Created by zhaoyu1 on 2017/6/1.
 */
open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

// 扩展函数
fun View.showOff() = println("I'm a View")

fun Button.showOff() = println("I'm a Button")      // 不起作用

fun main(args: Array<String>) {
    val view:View = Button()
    view.click()
    view.showOff()      // I'm a View
    println("=== 扩展函数 ==")
}