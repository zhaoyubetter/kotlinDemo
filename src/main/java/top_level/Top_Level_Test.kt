package top_level
import top_level.lastChar as last       // 导入

/**
 * Created by zhaoyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    println("Kotlin".last())

    println("========")

    val list = arrayListOf("1","2","3")
    println(list.joinString(","))
    println(list.join(","))

    val list2:MutableList<Int> = mutableListOf(55,200)
    list2.swap(0,1)
    println(list2.joinString(prefix = "[", separator = ",",postfix = "]"))
}