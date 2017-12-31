package fanxing

/**
 * Created by zhaoyu1 on 2017/7/7.
 */
class Test1 {
    /**
     * out 为型变注解，声明处协变，与Java使用处相反
     * 声明处型变 , Source 是 泛型 T 的生产者，而不是消费者
     */
    abstract class Source<out T> {
        abstract fun nextT(): T
    }

    fun method(strs: Source<String>) {
        val objects: Source<Any> = strs
    }

    // lev 1
    open internal class Food

    // lev 2
    open internal class Fruit : Food()

    // lev 3
    open internal class Apple : Fruit()

    internal class Banana : Fruit()

    // lev 4
    internal class RedApple : Apple()

    internal class Plate<T>(var item: T) {

        fun set(t: T) {
            item = t
        }

        fun get(): T {
            return item
        }
    }
}

fun main(args: Array<String>) {
    val p: Test1.Plate<Test1.Fruit> = Test1.Plate<Test1.Fruit>(Test1.Apple())
    p.set(Test1.RedApple())
    val f: Test1.Fruit = p.get()      // 这里与Java是相同的，只能返回 Fruit类型
    println(p.get())

    // 下面代码出错
    // val apple:Test1.RedApple = p.get()
}