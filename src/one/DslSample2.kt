package one

/**
 * Created by zhaoyu on 2017/6/22.
 */

val a = html {
    head {
        title = "www.jd.com"
        descriptin = "购物上京东"

    }
    body { }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

class HTML {
    fun head(init: Head.() -> Unit): Head {
        val head = Head()
        head.init()
        return head
    }

    fun body(init: Body.() -> Unit): Body {
        val body = Body()
        body.init()
        return body
    }
}

class Head {
    var title: String? = null
    var descriptin: String? = null
}

class Body {

}