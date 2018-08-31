package com.better.dsl.code

import com.better.dsl.cc

//fun MyTag.cc(init: MyTag.() -> Unit) {
//
//}

@DslMarker
annotation class MyTagDslMarker

@MyTagDslMarker
open abstract class MyTag(val name: String) {
    protected val children = mutableListOf<MyTag>()
    override fun toString(): String {
        return "<$name>${children.joinToString("")}</$name>"        // <td></td>
    }
}

@MyTagDslMarker
class MyTd : MyTag("td")

@MyTagDslMarker
class MyTr : MyTag("tr") {
    fun td(init: MyTd.() -> Unit) {
        val td = MyTd()
        td.init()
        children.add(td)
    }
}

@MyTagDslMarker
class MyTable : MyTag("table") {
    fun tr(init: MyTr.() -> Unit) {
        val tr = MyTr()
        tr.init()
        children.add(tr)
    }
}

fun table(init: MyTable.() -> Unit): MyTable {
    val table = MyTable()
    table.init()
    return table
}

fun main(args: Array<String>) {
    val ta2 = table {
        tr {
            td { }
            td {
            }
        }
    }

    val ta = table {
        (this@table).tr {
            (this@tr).td { }
            (this@tr).td { }
        }
    }

    //
    table {
        tr {
            table {
                (this@tr).td {
                }
            }
        }
    }

    println(ta)
}