package `fun`

/**
 * Created by zhaoyu on 2017/6/20.
 */
fun sum(vararg ar: Int): Int {
    var sum: Int = 0
    for (i in ar) {
        sum += i
    }
    return sum
}

fun main(args: Array<String>) {
    println(sum(1,2,3,4,5,6,6,7))

}

