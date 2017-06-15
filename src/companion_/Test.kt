package companion_

/**
 * 类似Java中的静态方法
 * Created by zhaoyu1 on 2017/6/2.
 */
class A {
    companion object {
        fun method() {
            println(this)
            println(" Companion object called")
        }

        @JvmStatic
        fun realStaticMethod() {
            println("Companion object called")
        }
    }

    var str:String = "better"
        set(value) {
            field = value
        }

}

class B {
    companion object {

    }
}

fun main(args: Array<String>) {
    A.method()      // 可直接访问，类型java中 static
    A.realStaticMethod()

    val a = A()
    a.str = "555"
    println(a.str)
}
