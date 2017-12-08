package com.better.classes_and_objects

/**
 */
class Test {
    var v = "成员属性"
    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

interface TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var test = Test()
    // 采用对象表达式来创建接口对象，即匿名内部类的实例。
    test.setInterFace(object :TestInterFace {
        override fun test() {
        }
    })
}