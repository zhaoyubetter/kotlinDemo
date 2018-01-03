package com.better.lambda

/**
 * 带接收者的函数字面值
 * Created by zhaoyu on 2018/1/1.
 */

val mySum = fun Int.(other: Int): Int = this + other

fun main(args: Array<String>) {
    // 函数字面值的类型是一个带有接收者的函数类型
    val sumOk : Int.(other:Int) -> Int = {this + it}   // 有点像扩展函数
    println(1.sumOk(2))
}