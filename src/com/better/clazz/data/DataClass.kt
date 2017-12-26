package com.better.clazz.data

/**
 * 数据类
 * Created by zhaoyu1 on 2017/12/18.
 */
data class DataClass(val name:String, val age:Int)


fun main(args: Array<String>) {
    // 特性：
    val data = DataClass("better", 30)
    println(data.toString())        // toString方法（DataClass(name=better,age=30)）

    // 复制copy()
    val data2 = data.copy(age=50)
    println(data2)

    // 解构,將构造中的字段分离出来，并赋值给
    val(myName, myAge) = data
    println("$myName, $myAge")
}