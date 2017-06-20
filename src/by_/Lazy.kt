package by_

/**
 * Created by zhaoyu on 2017/6/19.
 */
val lazyValue: String by lazy {
    println("computed")
    "better"
}

fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}

