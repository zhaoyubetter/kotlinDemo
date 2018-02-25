package fanxing

/**
 * Created by zhaoyu1 on 2017/7/7.
 */
class Test2 {
    /*
     kotlin 中没有泛型通配符的概念
     添加了协变（covariant）与型变(contravariant)
     协变只能用作read，只能用在方法的返回值，使用out修饰 <out T>，
     表示类型为T或T的子类 （像Java的 ？ extends T）【生产者】
     =>只能把out修饰的类型当做返回，而不是函数参数，进行传递
      */

    abstract class Source<out T> {
        //abstract fun setT(t:T)  // 不能当做参数进行消费
        abstract fun nextT(): T
    }

    class SourceImpl : Source<String>() {
        override fun nextT(): String {
            return "Kotlin 泛型 out"
        }
    }
}

fun main(args: Array<String>) {

}