package fanxing

/**
 * Created by zhaoyu1 on 2017/7/7.
 */
class Test1 {

    /**
     * 形变
     */
    class TypeClass<out T> {
        fun doSome() {

        }
    }

    data class UserInfo(val name: String, val age: Int)


    class MyCollection<out T> {
    }


    fun main(args: Array<String>) {
        val t1 = TypeClass<String>()
        val t2: TypeClass<Any> = t1     // 形变

        println(Test1::class.simpleName)
    }
}