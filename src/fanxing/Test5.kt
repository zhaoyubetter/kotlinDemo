package fanxing

import java.util.*

/**
 */
class Test5 {
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

    // ======= Array 既不是协变，也不是型变，可以看看源码

    // 投影

    /**
     * 将from数组中的数据copy到to
     */

    companion object {
        fun arrayCopy(from: Array<Any>, to: Array<Any>) {
            if (from.size == to.size) {
                for (i in from.indices) {
                    to[i] = from[i]
                }
            }
        }

        // 修改后
        /**
         *  <out Any>   <? extends Any>
         *  <in Any>  <? super Any>
         */
        fun arrayCopy2(from: Array<out Any>, to: Array<in Any>) {
            if (from.size == to.size) {
                for (i in from.indices) {
                    to[i] = from[i]
                }
            }
        }

    }
}

fun main(args: Array<String>) {
    val from_ints = arrayOf(1, 2, 3)
    val to_anys = arrayOfNulls<Any>(3)

    // 以下代码有错误，泛型强制约束了, Array 在 T 上不型变
    // Test5.arrayCopy(from = from_ints, to = to_anys)


    // === 使用 2
    Test5.arrayCopy2(from = from_ints, to = to_anys)
    println(Arrays.toString(to_anys))
}