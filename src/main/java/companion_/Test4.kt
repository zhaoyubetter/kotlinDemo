package cz.sample.kotlin.companion_


class A {

    var name = "better"

    companion object {
        fun method() {
            println("A.method() called!")
        }
    }
}

fun main(args: Array<String>) {
    A.method() // 类似java的静态方法调用
}