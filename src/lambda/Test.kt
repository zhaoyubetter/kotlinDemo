package lambda

/**
 * Created by zhaoyu on 2017/6/5.
 */
fun main(args: Array<String>) {
    sayHello.invoke("better", "hello world")
}

val sayHello = { name: String, msg: String ->
    println("$name say $msg to you")
}



