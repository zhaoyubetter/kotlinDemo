package one

/**
 * null 检测
 * Created by zhaoyu on 2017/5/26.
 */
// 加入？,表示该变量可为null
fun getStringLength(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length       // 这个不错，无需强制转换
    }
    return null
}


// ?: 运算符 进行null判断
fun main(args: Array<String>) {
    fun printLen(obj: Any) {
        println("'${obj}' string length is ${getStringLength(obj) ?: "not a string"}")
    }
    printLen("zhaoyubetter")
    printLen(100000)
    printLen(listOf(Any()))

    println("======= if not null 缩写(?.) =======")
    var str: String? = null     // ?表示允许为null
    println(str?.length)  // null

    println("===== if not null and else 缩写(?. ?:) ====")
    println(str?.length ?: "empty")     // 为null打印empty

    println("==== if null (?:)==== ")
    val data = mapOf("a" to 1, "b" to 2)
//    val c = data["c"] ?: throw IllegalAccessException("c is missing!")

    println("===== let =====")
    val withNullList = listOf("abc", null, "bbcc")
    for (item in withNullList) {
        item?.let { println(it) }
    }

    ///////// 为 null pointer 爱好者 准备的，这里将抛出异常
    println("===== !! ====")
    val b: String? = null
    println(b!!.length)
}