package com.better.inline

/**
 * 非局部返回
 * Created by zhaoyu on 2018/1/4.
 */
// lambda
val colsure = { a: Int, b: Int, init: () -> Unit -> a + b }

inline fun foo() {
    colsure(1, 2) {
        // return //不允许返回
        return@colsure  // 需要使用标签 退出lambda
    }
}

// groovy 中，这样返回还是 false，这里因为 forEach 是内联的
fun hasZero(ints: List<Int>): Boolean {
    ints.forEach { if (it == 0) return true }   // 非局部返回
    return false
}

// 我们再测试 （不内联的情况下）
private  fun <T> Iterable<T>.myForEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

// 感觉不错
fun myhasZero(ints: List<Int>): Boolean {
    ints.myForEach { if (it == 0) return@myForEach }
    return false
}

fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 0)
    println(hasZero(list))
    println(myhasZero(list))        // false
}
