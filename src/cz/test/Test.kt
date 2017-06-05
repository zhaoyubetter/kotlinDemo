package cz.test

import com.google.gson.JsonParser

/**
 * Created by zhaoyu on 2017/6/4.
 */
fun main(args: Array<String>) {
    println(isJson("[]"))
}

fun isJson(value: String?): Boolean {
    var result = false
    try {
        val jsonElement = JsonParser().parse(value)
        result = (jsonElement.isJsonArray || jsonElement.isJsonObject)
    } catch (e: Exception) {
        result = false
    }
    return result
}