package extend_jdk

/**
 * Created by zhaoyu1 on 2017/6/1.
 */
fun main(args: Array<String>) {
    val strings: List<String> = listOf("one", "two", "three")
    println(strings.last())     // last 为扩展

    val numbers:Collection<Int> = setOf(1,9,22)
    println(numbers.max())      // max()
}