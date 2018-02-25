package `fun`

/**
 * 中缀
 * Created by zhaoyu on 2017/6/20.
 */

// 添加扩展函数
infix fun Int.double(x:Int):Int {
    return x*2
}

// 单表达式类型
fun Int.double2(x:Int=2):Int = x * 2

fun Int.double3(x:Int=2) = x * 2


fun main(args: Array<String>) {
    println(2 double 5)
    println(2.double(5))

    println(2.double(x=5))
}
