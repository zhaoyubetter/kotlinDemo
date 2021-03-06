package com.better.extends_2

/**
 * 例子：父亲work，孩子哭了；
 * 分发接收者与扩展接收者名字冲突时如何处理？
 * Created by zhaoyu1 on 2017/12/25.
 *
 */
class Child {
    fun cry() {
        println("Child cry")
    }
}

fun Child.extends() {
    cry()
}

class Father {
    fun work() {
        println("Father work()")
    }

    fun goHome() {
        println("Father goHome()")
    }

    fun Child.extends() {
        this@Father.work()
        cry()
        this@Father.goHome()
    }

    fun invoke(c:Child) {
        c.extends()     // // 就近原则,调用上面的扩展
    }
}

fun main(args: Array<String>) {
    val child = Child()
    val father = Father()
    father.invoke(child)        // 就近原则
}
