package obj_expr

/**
 * Created by zhaoyu1 on 2017/6/19.
 */
open class A(x: Int) {
    open val y: Int = x
}

interface B {}

val ab: A = object : A(1), B {
    override val y = 15
}

fun foo() {
    val addHoc = object {
        var x: Int = 0
        val y: Int = 0
    }
}


