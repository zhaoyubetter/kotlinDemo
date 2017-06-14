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
                            postfix: String = "") = joinString(separator, prefix, postfix)

// 1.扩展函数，String为扩展的类，receiver type;  this 为接收器对象 receiver obj
// 添加了方法到String类
fun String.lastChar(): Char = this.get(this.length - 1)     // or get(length - 1)

// 2.添加扩展属性
val String.lastChar: Char
    get() = get(length - 1)

// 为 StringBuilder添加扩展属性
var StringBuilder.lastChar: Char
    get() = get(length - 1)     // getter
    set(value: Char) {          // setter
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar())        // Kotlin 为接收器对象
    println("better".lastChar)  // 扩展属性

    println("扩展属性 for StringBuilder")
    var sb = StringBuilder("Kotlin?")
    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb)
}

// 扩展函数
fun <T> MutableList<T>.swap(index1:Int, index2:Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
