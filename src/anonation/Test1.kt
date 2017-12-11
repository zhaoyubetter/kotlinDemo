package anonation

/**
 * Created by zhaoyu on 2017/6/22.
 */


// 定义注解
annotation class ReplaceWith(val expression: String)

// 定义注解
annotation class Deprecated(
        val message: String,
        val replaceWith: ReplaceWith = ReplaceWith(""))

@Deprecated("not use", replaceWith = ReplaceWith("other")) class Foo {
    fun baz(foo: Int): Int {
        return (1)
    }
}

fun main(args: Array<String>) {
//    val f : Foo = Foo()

    val tmpArray = mutableListOf(9,2,-1,20,80,50,30,8).toIntArray()
    (0..tmpArray.size - 2).forEach { i ->
        (0..tmpArray.size  - i - 2).forEach { j ->
            if (tmpArray[j] > tmpArray[j + 1]) {
                val tmp=tmpArray[j]
                tmpArray[j]=tmpArray[j+1]
                tmpArray[j+1]=tmp
            }
        }
    }

    println(tmpArray.forEach { print(" ${it}") })
}
