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


    val reduce = brand.reduce { acc, s -> acc + s }
    println(reduce)
    brand.flatMap { it.map { it } }.map { it.toString() }.reduce{acc,i->if(i in acc) acc else acc+i}.forEach { print(it) }

    println("==== map ====")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)       // 创建map
    println(map["a"])
}