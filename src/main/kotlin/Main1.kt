import com.test._packag.test1

fun main(args: Array<String>) {
    test1()

//    val list = listOf(1,2,4,5,6)
//    val str = list.joinToString(separator = "||", postfix = "}", prefix = "{")
//    println(str)

    val a: String? = null   // String? 表示a可以为null
    println(a.toString())  // 输出null，不会报nullPointer
    println(a?.toString()) // 输出null，不做处理

    val b = getName()
    println(b?.toString())

    val num = 1_000
    println(num)

    val i: Long = 1
    val j: Short = 2
    val m = i + j
    println(m::class)


    val c: Char = 'A'

    val mm: Int = 55
    val cc = mm as Long     // 不好意思我报错了
    println(cc)

    val aa :Any = "cc"
}

fun getName(): String? {        // 如果方法可能返回 null，返回值为 Any?
    return null
}

