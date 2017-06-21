package others

/**
 * 集合操作
 * Created by zhaoyu on 2017/6/21.
 */

val readOnlyList = listOf<Int>(1, 2, 3)
val list = mutableListOf<Int>(4, 5, 6, 7, 8)

fun main(args: Array<String>) {
    println(list.first())
    println(list.first { it % 3 == 2 })
    println(list.filter { it % 2 == 0 })
    println(list.reduce { total, i -> total + i })  // 求个和

    println(list.map { it * 2 }) // 增加2倍
    println(list.flatMap { listOf(1) }) // 1,1,1,1,1
    list.sortWith(Comparator { o1, o2 -> o2 - o1 }) // 降序排列
    println(list)

    println(list.zip(listOf("a", "b", "c", "d")))   // (8,a),(7,b),这种


    juhe()
    filter()
    map()
}

/**
 * 聚合操作
 */
fun juhe() {
    println("=== 一些聚合操作运算 ==")

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    // any: 至少有一个与条件相符
    println(list.any { it > 0 })

    // all: 与所有条件符合，才返回true
    println(list.all { it > 6 })

    // count: 返回与条件匹配相同的个数
    println(list.count { it % 2 == 0 })

    // fold: 从初始值 递减 list 中的每一项
    println(list.fold(100) { original, it -> original - it })  // 64
    println(list.fold(0) { original, it -> original + it })     // 求和

    // forEach： 让每一项执行相同的操作
    list.forEach { it * 2 }

    // none: 没有元素与这个条件符合时，返回true
    println(list.none { it % 100 == 0 })

    // reduce: 同 fold，只是没有初始值
    println(list.reduce { total, next -> total + next }) // 求个和
}

/**
 * 筛选操作
 */
fun filter() {
    println("=== 一些筛选操作运算 ==")

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    // filter: 过滤
    println(list.filter { it % 2 == 0 })

    // slice：返回指定索引初的元素
    println(list.slice(listOf(1, 2)))   // 2,3

    // takeWhile: 返回满足条件的第一个列表《切割的意思》
    println(list.takeWhile { it < 3 })  // 1,2

    // dropWhile: 返回所有元素类别，但不包括 满足条件的
    println(list.dropWhile { it < 3 })
}

/**
 * 映射操作相关
 */
fun map() {
    println("=== 一些映射操作运算 ==")

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    // flatMap：遍历每个元素创建一个新集合，并加入新元素，把所有集合整合到包含所有元素的唯一列表中。
    println(list.flatMap { listOf(10) }) // 10,10,10,10,10,10,10

    // groupBy:分组，返回映射表
    println(list.groupBy { if (it % 2 == 0) "even" else "odd" })

    // map: 返回列表，并且列表中的每个元素进行了转换
    println(list.map { it * 2 })
}
