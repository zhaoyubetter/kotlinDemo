package com.better.lambda.code

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,6,7,8)
    // 1.匿名函数
    list.map {
        fun(it:Int):String {
            return "number" + it
        }
    }
    // 2.匿名函数简写形式
    list.map {fun(it:Int) = "number"+ it}
    // 3.lambda
    list.map { it -> "number: " + it}
    // 4.省略默认it
    list.map { "number: " + it }
    // 5.使用外界函数也是可以的：反射的时候，我们再过一下
}
