package cz.sample.kotlin.companion_

// 对象表达式

fun main(args: Array<String>) {
    Thread(object: Runnable {
        override fun run() {
            // 啦啦啦
        }
    }).start()
}