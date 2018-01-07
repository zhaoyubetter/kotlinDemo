package com.better.lambda.code

fun <T> max(col: Collection<T>, less: (T, T) -> Boolean) : T?{
    var max:T? = null
    for(it in col) {
        if(max == null || less(it, max)) {
            max = it
        }
    }
    return max
}

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,6,7,8)
    var max = max(list,  {a:Int, b:Int -> a > b})
    println(max)
}