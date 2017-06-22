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
    val f : Foo = Foo()
}
