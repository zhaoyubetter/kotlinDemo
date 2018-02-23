package fanxing

/**
 * Created by zhaoyu1 on 2017/7/7.
 */
class Test3 {
    /*
     kotlin 中没有泛型通配符的概念
     添加了协变（covariant）与型变(contravariant)
     协变只能用作read，只能用在方法的返回值，使用out修饰 <out T>，
     表示类型为T或T的子类 （像Java的 ？ extends T）【生产者】
     =>只能把out修饰的类型当做返回，而不是函数参数，进行传递
      */

    /* in 型变
       in修饰的类型，只能作为函数的入参
       只能被消费，不能被生产
     */

    class Router<in T> {
        fun compute(t: T): Int = 0      // 函数的入参
    }

    fun go(router: Router<String>) {
        var st:Router<String> = router
        // 以下出错，
        //var t:Router<Any> = router
    }

    fun go2(router:Router<Any>) {
        var s:Router<String> = router  // 跟java 类似
    }
}

fun main(args: Array<String>) {

}