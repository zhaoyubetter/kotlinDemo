package companion_

/**
 * 类似Java中的静态方法
 * Created by zhaoyu1 on 2017/6/2.
 */
class A {
    companion object {
        fun method() {
            println("Companion object called")
        }
    }
    fun test() = "124"
}

fun main(args: Array<String>) {
    A.method()      // 可直接访问，类型java中 static
}
