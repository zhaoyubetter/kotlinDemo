package test
import top_level.join
import top_level.joinString
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
}