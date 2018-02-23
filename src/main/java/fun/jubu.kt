package `fun`

/**
 * 局部函数
 * Created by zhaoyu on 2017/6/20.
 */

infix fun Int.divide(x: Int): Int {
    fun check() {
        if (x == 0)
            throw IllegalAccessError()
    }
    check()
    return this / x
}

fun main(args: Array<String>) {
    println(5 divide 2)
}
