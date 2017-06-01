package one

/**
 * Created by zhaoyu on 2017/5/26.
 */
fun main(args: Array<String>) {
    val items = listOf("apple", "android", "windows")
    for (i in items) {
        println(i)
    }

    // 根据索引来
    for (index in items.indices) {
        println("item at ${index} is ${items[index]}")
    }

    // use while 循环
    var index = 0
    while (index < items.size) {
        println("item at ${index} is ${items[index]}")
        index++
    }
}