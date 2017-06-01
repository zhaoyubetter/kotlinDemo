package one

/**
 * Created by zhaoyu on 2017/5/27.
 */
fun main(args: Array<String>) {
    val brand = listOf("apple", "android", "windows", "linux")
    brand
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println("==== map ====")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)       // 创建map
    println(map["a"])
}