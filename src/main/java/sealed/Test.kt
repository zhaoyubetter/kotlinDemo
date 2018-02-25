package sealed

/**
 * 密封类
 * Created by zhaoyu on 2017/6/15.
 */

sealed class Expr

data class Const(val number: Double) : Expr()               // 子类
data class Sum(val num1: Expr, val num2: Expr) : Expr()     // 子类
object NotANumber : Expr()

// 密封类 when 的使用
fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.num1) + eval(expr.num2)
    NotANumber -> Double.NaN        // 不需要写 else
}


fun main(args: Array<String>) {
    val a1:Expr = Const(2.0)
    val a2:Expr = Const(3.0)
    val a3:Expr = Sum(a1, a2)
    println(eval(a1))
    println(a3)
}
