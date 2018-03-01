package com.better.json.data

import com.better.json.CustomSerializer
import com.better.json.JsonExclude
import com.better.json.JsonName
import com.better.json.ValueSerializer
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

// 县
data class County(val name: String, val peopleCount: Int)

// 市
data class City(val name: String, val counties: List<County>)

// 省
data class Province(val name: String, val size: Int, val cities: List<City>?)

data class UserBean(@JsonExclude val username: String, @JsonName("myAge") val age: Int) {
    // map 有待支持
    val map = HashMap<String, Int>()
    init {
        map["Abc"] = 567
        map["Def"] = 999
    }
}

data class MyTime(@CustomSerializer(DateSerializer::class) val birthday: Long?, val name: String)

object DateSerializer : ValueSerializer<Long> {
    private val dmt = SimpleDateFormat("yyyy-MM-dd")
    override fun toJsonValue(value: Long): Any? = if (value == null) null else dmt.format(Date())
    // TODO:
    override fun fromJsonValue(jsonValue: Any?): Long {
        return 11111L
    }
}