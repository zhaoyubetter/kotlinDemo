package two

/**
 * Created by zhaoyu on 2017/5/27.
 */
fun main(args: Array<String>) {
    val a: Int = 100_00
    println(a === a)

    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA)       // false

    println("相等性")

    println(boxedA == anotherBoxedA)        // true
}

