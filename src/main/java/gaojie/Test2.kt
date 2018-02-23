package gaojie

/**
 * 接收者对象
 * Created by zhaoyu on 2017/6/20.
 */


val sum = fun Int.(other: Int): Int = this + other

val items = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


fun main(args: Array<String>) {
    println(sum(2, 2))  // 4

    val curIndex = 3;
    val limit = 2;

    val startOffset = Math.max(0, curIndex - limit)
    val endOffset = Math.min(items.size - 1, curIndex + limit)

//    items.filter { it >= startOffset || it <= endOffset }.forEach { println(it) }

//    (startOffset..endOffset).forEach { pos ->
//        println("pos->$pos" )
//        if (items.none { it == pos }) {
//            println(pos)
//        }
//    }


    println(items.none { it == 100 })
}