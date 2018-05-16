package companion_

/**
 * 类似Java中的静态方法
 */
class A {
    companion object  { // companion object good
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
    companion object Better {   // 指定名字
    }
}

fun main(args: Array<String>) {
    A.method()      // 可直接访问，类型java中 static
    A.realStaticMethod()

    val a = A()
    a.str = "555"
    println(a.str)
}
