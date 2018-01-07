package com.better.lambda.code

fun main(args: Array<String>) {
    html {
        body {
            content()
        }
    }
}

class HTML {
    fun body(init: Body.()->Unit) {
        println("body")
        val body = Body()
        body.content()
    }
}

class Body {
    fun content() {
        println("content")
    }
}

fun html(init: HTML.()->Unit) :HTML{
    val html = HTML()
    html.init()     // 调用扩展
    return html
}