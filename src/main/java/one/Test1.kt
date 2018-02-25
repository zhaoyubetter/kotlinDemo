package one

/**
 * Created by zhaoyu on 2017/5/26.
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int): Int = a + b

fun main(args: Array<String>) {
    println(sum(2, 5))
    println("sum of 12 and 13 is ${sum(12, 13)}")
}
