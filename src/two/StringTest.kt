package two

/**
 * Created by zhaoyu on 2017/5/29.
 */
fun main(args: Array<String>) {
    val text = """
            |better,
            |better2
        """.trimMargin()

    println(text)

    println()

    val price = """
        ${'$'}9.99
        """
    println(price)
}
