package extend_jdk

/**
 * 扩展声明为成员
 * Created by zhaoyu1 on 2017/6/15.
 */

fun main(args: Array<String>) {
    Class_C().caller(Class_D())
}

class Class_D {
    override fun toString(): String {
        println("D 类 toString() 方法调用...")
        return super.toString()
    }
}

class Class_C {
    fun baz() {}

    // 为D类增加扩展方法
    fun Class_D.foo() {
        toString()          // 扩展接收者 D 类的toString
        this@Class_C.toString()   // 分发接收者使用 this
    }

    fun caller(d: Class_D) {
        d.foo()       // 调用扩展函数
    }

    override fun toString(): String {
        println("C 类 toString() 方法调用")
        return super.toString()
    }
}
