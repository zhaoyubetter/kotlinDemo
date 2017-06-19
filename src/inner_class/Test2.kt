package inner_class

/**
 * Created by zhaoyu on 2017/6/18.
 */
class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun test() = bar
    }
}

fun main(args: Array<String>) {
    Outer().Inner().test()  // 需要先创建外部类
}