package others

/**
 * 区间
 *
 * Created by zhaoyu on 2017/6/21.
 */
fun main(args: Array<String>) {
    for (i in 1..10) {
        println(i)
    }

    var a: Any = 123
    println(a as Int)       // 强制转换

    var b: String = "123"
    println(b as Int)   // 类型转换错误
    println(b as? Int)  // 输出 null，
}
