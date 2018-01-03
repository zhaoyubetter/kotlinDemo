package extend_jdk

/**
 * Created by zhaoyu1 on 2017/6/1.
 */
fun main(args: Array<String>) {
    val strings: List<String> = listOf("one", "two", "three")
    println(strings.last())     // last 为扩展

    val numbers: Collection<Int> = setOf(1, 9, 22)
    println(numbers.max())      // max()

    //println("")
    printFoo(D())
}


///////////////////////////////////////////////
open class C

open class D : C()

fun C.foo() = "from class C"            // 为C添加扩展方法

fun D.foo() = "=====> from class D"     // 为D添加扩展方法

var C.receivers:HashMap<String, String>
    set(value) {

    }
    get() = hashMapOf<String, String>()



// 顶级方法
fun printFoo(c: D) {        // 传 C 打印C，传D打印D，不会根据运行时，动态匹配（没有多态）
    println(c.foo())

    val c = C()

    println("=====")
    c.receivers.put("a", "a")
    c.receivers.put("b", "b")
    println(c.receivers.size)  // 0

    c.receivers.forEach { it -> println(it.key) }
}

