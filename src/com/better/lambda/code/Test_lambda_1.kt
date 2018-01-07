package com.better.lambda.code

// 1. 原始形式
val sum1: (Int,Int) -> Int = fun(x:Int, y:Int) : Int {
    return x + y
}
// 2. 简写一下
val sum2 : (Int,Int) -> Int = fun(x:Int, y:Int) = x + y

// 3. 再简写(匿名函数已经定义好参数列表和返回值类型了，省略 sum 的类型声明)
val sum3  = fun(x:Int, y:Int) = x + y

// 4. 再次精简，Lambda 表达式就是一个匿名函数，把这个匿名函数改写为 Lambda 表达式
val sum4 = {x:Int, y:Int -> x + y}

fun main(args: Array<String>) {
    println(sum1(1,2))
    println(sum4.invoke(1,2))
}