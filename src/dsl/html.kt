package dsl

/**
 * Created by zhaoyu on 2017/6/22.
 */

@DslMarker annotation class HtmlTagMarker

/**
 * 元素
 */
interface Element {
    // 渲染
    fun render(builder: StringBuilder, indent: String)
}

// 文本元素
class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

@HtmlTagMarker
abstract class Tag(val name: String) : Element {

    val children = arrayListOf<Element>()
    val attributes = hashMapOf<String, String>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            builder.append(c.render(builder, indent + "    "))
        }
        builder.append("$indent</$name>\n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

    private fun renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in attributes) {
            builder.append(" $attr=\"$value \" ")
        }
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    // 重载操作符 operator
    operator fun String.unaryPlus() {
        children.add(TextElement(this)) // 加入标签中
    }
}

class HTML : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class Head : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(init: B.() -> Unit) = initTag(B(), init)
    fun p(init: P.() -> Unit) = initTag(P(), init)
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
    fun a(href: String, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.href = href
    }
}

class Body : BodyTag("body")
class B : BodyTag("b")
class P : BodyTag("p")
class H1 : BodyTag("h1")


class A : BodyTag("a") {
    var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

fun main(args: Array<String>) {
  val html = html {
        body {
            a("www.jd.com") { +"abc" }
            p { "p" }
            b { "b" }
        }
        head {
            title { +"title" }      // 加入标签中
        }
    }

    println(html)
}

