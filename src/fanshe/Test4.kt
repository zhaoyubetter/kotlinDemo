package fanshe

/**
 * Created by zhaoyu on 2017/6/22.
 */


fun main(args: Array<String>) {

    // 引用特定对象的实例方法
    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("29"))  // true

    // 取代直接调用方法 matches 存储其引用
    val isNumber = numberRegex::matches
    println(isNumber("29"))

    val strings = listOf<String>("abc", "123")
    println(strings.filter(isNumber))       // 输出 123
    println(strings.filter(numberRegex::matches))

    val isNumbe2r: (CharSequence) -> Boolean = numberRegex::matches

}

