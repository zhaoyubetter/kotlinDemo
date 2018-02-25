package cz.sample.kotlin

/**
 * Created by cz on 2017/8/2.
 */
fun main(args: Array<String>) {
    println(Integer.toBinaryString(MeasureSpec.MODE_MASK))
    println(Integer.toBinaryString(MeasureSpec.UNSPECIFIED))
    println(Integer.toBinaryString(MeasureSpec.EXACTLY))
    println(Integer.toBinaryString(MeasureSpec.AT_MOST))
    //0x01 0x02 0x04 0x08
//    00111111111111111111111111111111
//    01000000000000000000000000001000
//    10000000000000000000000000000000
    val widthSpec = MeasureSpec.makeSpec(MeasureSpec.EXACTLY, 10000000)
    println(Integer.toBinaryString(widthSpec))
    println(Integer.toBinaryString(10000000))
    println("mode=${Integer.toBinaryString(MeasureSpec.getMode(widthSpec))}")
    println("size=${Integer.toBinaryString(MeasureSpec.getSize(widthSpec))}")
//    println(Integer.toBinaryString(widthSpec))
}


object MeasureSpec {
    private val MODE_SHIFT = 30
    val MODE_MASK = 0x3 shl MODE_SHIFT
    val UNSPECIFIED = 0 shl MODE_SHIFT
    val EXACTLY = 1 shl MODE_SHIFT
    val AT_MOST = 2 shl MODE_SHIFT

    fun makeSpec(mode: Int, size: Int) = mode + size
    fun getMode(measureSpec: Int): Int {
        return measureSpec and MODE_MASK
    }

    fun getSize(measureSpec: Int): Int {
        return measureSpec and MODE_MASK.inv()
    }

}