package com.better.delegate.code

// 局部属性委托,不好意思，不好意思，没找到合适例子
class Test8_Property_local_by {
    fun method(closure: ()->Boolean) {
        val tmp by lazy(closure)
        println(tmp)
    }
}

fun main(args: Array<String>) {
    val test = Test8_Property_local_by()
    test.method {
        println("called()")
        true
    }

    test.method {
        println("called()")
        true
    }
}