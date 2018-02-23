package one

/**
 * Created by zhaoyu on 2017/5/27.
 */
fun main(args: Array<String>) {
    val x = 10
    val y = 9
    // in 运算符检测 是否指定的范围之内
    if (x in 1..y + 1) {
        println("${x}...in range")
    }

    val list = listOf("a", "b", "c")
    println(list.lastIndex)     // 最后下标
    println(list.size)          // 长度
    println(list.indices)       // 返回区间

    println("===== 区间 =")
    for (x in 0..5) {        // [0,5]
        println(x)
    }

    for (x in 1..20 step 2) {
        println(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    println("======= setOf =====")
    val items = setOf<String>("one", "two", "three", "one")     // 返回Set
    for (item in items) {
        println(item)
    }

    println("====")
    val myList = arrayListOf("10", "11", "1001")
    for ((i, it) in myList.withIndex()) {
        println("$i --> $it")
    }
}