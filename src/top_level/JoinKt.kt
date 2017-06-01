@file:JvmName("StringFunctions")

// 改变文件类名

package top_level


/**
 * 顶层函数
 * Created by zhaoyu on 2017/5/31.
 */
// 默认参数值，解决Java重载方法过多问题（重载过多，造成了很多重复代码）
fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""): String {

    val result = StringBuilder(prefix)
    for ((index, item) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(item)
    }

    result.append(postfix)
    return result.toString()
}


// 扩展 Collection
fun <T> Collection<T>.joinString(separator: String = ", ",
                                 prefix: String = "",
                                 postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, item) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(item)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String = ", ",
                       prefix: String = "",
                       postfix: String = "") = joinString(separator,prefix,postfix)

// 扩展函数，String为扩展的类，receiver type;  this 为接收器对象 receiver obj
// 添加了方法到String类
fun String.lastChar(): Char = this.get(this.length - 1)     // or get(length - 1)

// 扩展属性

fun main(args: Array<String>) {
    println("Kotlin".lastChar())        // Kotlin 为接收器对象

}
