package com.better.inline

/**
 * 属性内联
 * Created by zhaoyu on 2018/1/4.
 */
class Test3_inline_3_prop {
    val name: String
        inline get() = "abc"

    var age: Int = 20

}

fun main(args: Array<String>) {
    val test = Test3_inline_3_prop()
    test.name

    Int
}