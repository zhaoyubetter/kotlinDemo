package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/3.
 */

class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

fun main(args: Array<String>) {
    // 可空类型String?被用来替换T 出错
    // val nullableString = Processor<String?>()
    // 可传递null
    // nullableString.process(null)
}