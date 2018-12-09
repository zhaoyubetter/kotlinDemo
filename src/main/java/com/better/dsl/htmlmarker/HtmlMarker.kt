package com.better.dsl.htmlmarker

import dsl.Title
import javax.xml.soap.Text

/**
 * <pre>
<html>
<head>header</head>
<a href="www.kotlin.org">kotlin</a>
<br/>
</html>
 * </pre>
 **/

fun main(args: Array<String>) {

    val result =
            html {
                head {
                    title { -"hello" }
                }
                body {
                    a(href = "http://www.google.com", color = "white") {
                        -"Google"
                    }
                }
            }

    println(result)

}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

abstract class Tag(private val name: String) : Element {

    protected val children = arrayListOf<Element>()
    protected val attributes = hashMapOf<String, String>()

    /**
     * 1.先初始化
     */
    protected fun <T : Element> initTag(t: T, init: T.() -> Unit): T {
        t.init()
        children.add(t)
        return t
    }

    /**
     * 2. 再render
     */
    override fun render(builder: StringBuilder, indent: String) {
        /* <font color='aaa'>
               <xxx></xxx>
           </font>
         */
        builder.append("$indent<$name${renderAttrs()}>\n")
        for (child in children) {
            child.render(builder, "$indent ")  // 注意这里有空格
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttrs(): String {
        val builder = StringBuilder()
        for (attr in attributes) {
            builder.append(" ${attr.key}=\"${attr.value}\"")
        }
        return builder.toString()
    }

    override fun toString(): String {
        return StringBuilder().apply {
            render(this, "")
        }.toString()
    }
}

// just text
class TextElement(private val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

abstract class TagWithTag(text: String) : Tag(text) {
    operator fun String.unaryMinus() {
        children.add(TextElement(this))
    }
}

class TitleTag : TagWithTag("title")


class Html : Tag("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)
    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}

class Head : Tag("head") {
    fun title(init: TitleTag.() -> Unit) = initTag(TitleTag(), init)
}

class A : TagWithTag("a") {
    var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }

    var color: String
        get() = attributes["color"]!!
        set(value) {
            attributes["color"] = value
        }
}


class Body : Tag("body") {
    fun a(href: String, color: String, init: A.() -> Unit): A {
        val a = A()
        a.href = href
        a.color = color
        return initTag(a, init)
    }
}
