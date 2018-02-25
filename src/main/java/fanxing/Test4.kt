package fanxing

/**
 */
class Test4 {
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


    abstract class Comparable<in T> {
        abstract fun compareTo(other: T): Int
    }

    fun demo(x: Comparable<Number>) {
        x.compareTo(1.0)    // double 是 Number 的子类
        val y:Comparable<Double> = x  //
    }

}

fun main(args: Array<String>) {
    // Array
}