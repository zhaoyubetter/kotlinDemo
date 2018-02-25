package by_

import kotlin.properties.Delegates

/**
 * Created by zhaoyu on 2017/6/19.
 */
class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "better"
    user.name = "best"
}