package three


/**
 * Created by zhaoyu on 2017/5/31.
 */
class Rectangle(val height: Int, val width: Int) {
    // 自定义属性访问器
    val isSquare: Boolean
        get() = (height == width)
}

fun main(args: Array<String>) {
    val rect = Rectangle(200, 200)
    println(rect.isSquare)
}