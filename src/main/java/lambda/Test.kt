package lambda

/**
 * Created by zhaoyu on 2017/6/5.
 */
fun main(args: Array<String>) {
    sayHello.invoke("better", "hello world")

    println("hello".padEnd(20, '='))
}

val sayHello = { name: String, msg: String ->
    println("$name say $msg to you")
}



