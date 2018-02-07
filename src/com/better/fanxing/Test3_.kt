package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/3.
 */

interface MyLIst<T>
class StringList : MyLIst<String> // 具体类型实参
class MyList<T:Number> : MyLIst<T>       // 泛型类型形参

fun <T> MyLIst<T>.sum2():Unit where T : Number , T: Appendable {
}

fun main(args: Array<String>) {
    val my = MyList<Int>()
}