package com.test.unit

import java.util.concurrent.Callable


class NoResultCallable : Callable<Unit> {   // 返回Unit，可省略类型说明
    override fun call() {
        // 不需要显示return
    }
}
class IntResultCallable : Callable<Int> {
    override fun call(): Int {
        return 1    // 必须返回
    }
}