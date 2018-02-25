package com.better.json.deserialize

/**
 * json to object 反序列化
 **/

/**
 * 解析器, 负责将无格式的标记列表转换为结构化表示方法；
 * 解析成JSON中的语义：键值对、对象和数组；
 */
interface JsonObject {
    /**
     * Key-Value
     */
    fun setSimpleProperty(propertyName: String, value: Any?)

    /**
     * Object, such as Map
     */
    fun createObject(propertyName: String): JsonObject

    /**
     * Array
     */
    fun createArray(propertyName: String): JsonObject
}