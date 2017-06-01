package collection

/**
 * Created by zhaoyu on 2017/5/31.
 */
fun main(args: Array<String>) {
    val set = setOf(1, 5, 2, 3)
    val list = listOf(2, 4, 5)
    val map = mapOf(1 to "one", 2 to "two")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(set.max())

    println("======")
    println(list)       // 输出 [2,4,5]
    println(set)

    println("使用 joinToString ")
    println(joinToString(set, "; ", "(", ")"))         // 超级不错
    // 有名字的参数，但这个不支持java中定义的方法
    println(joinToString(collection = list, prefix = "{", postfix = "}", separator = "; "))

    // 使用参数默认值
    println(joinToString2(collection = list))

    println("====")
}

/**
 * 给String类注入一个新方法 joinToString
 */
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String): String {

    val result = StringBuilder(prefix)
    for ((index, item) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(item)
    }

    result.append(postfix)
    return result.toString()
}

// 默认参数值，解决Java重载方法过多问题（重载过多，造成了很多重复代码）
fun <T> joinToString2(
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
