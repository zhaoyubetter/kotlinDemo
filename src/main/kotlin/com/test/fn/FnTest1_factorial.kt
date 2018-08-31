package com.test.fn

fun main(args: Array<String>) {
    val n = 3

    // 1.阶乘函数
    println(factorial(3))

    // 2.使用reduce
    val result = (n downTo 1).myReduce { result, next -> result * next }
    println(result)
}

// 阶乘，用到了递归
fun factorial(n: Int): Int {
    return if (n > 1) {
        n.times(factorial(n - 1))
    } else {
        1
    }
}


// 系统的 reduce 函数
fun <S, T : S> Iterable<T>.myReduce(operation: (S, T) -> S): S {
    val iterator = this.iterator()
    if (!iterator.hasNext()) {
        throw RuntimeException("empty !")
    }

    var result: S = iterator.next()
    while (iterator.hasNext()) {
        result = operation(result, iterator.next())
    }
    return result
}