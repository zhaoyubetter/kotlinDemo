package three

/**
 * Created by zhaoyu on 2017/5/31.
 */
interface Expr

class Num(val value: Int) : Expr        // 实现Expr接口

class Sum(val left: Expr, val right: Expr) : Expr


fun eval(e: Expr): Int {

    /*
    if (e is Num) {
        return e.value      // smart case
    } else if(e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalAccessException("表达式错误")
    */


    /*
    when (e) {
        is Num -> return e.value
        is Sum -> return eval(e.left) + eval(e.right)
        else -> throw IllegalAccessException("表达式错误")
    }*/

    when (e) {
        is Num -> {
            println("num: ${e.value}")
            return e.value     // e是Num时，将返回
        }
        is Sum -> {
            val left = eval(e.left)
            val right = eval(e.right)
            println("sum: $left + $right")
            return left + right
        }
        else -> throw IllegalAccessException("表达式错误")
    }
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}