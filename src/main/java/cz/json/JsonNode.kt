package cz.json

import cz.model.FieldType


/**
 * json节点类
 * Created by cz on 2017/5/24.
 */
/**
 * @param parentNode 父节点
 * @param name node 名称
 * @param type 类型
 * @param level 层级
 */
data class JsonNode(var parentNode: JsonNode?, val name: String, var type: FieldType, val level: Int) {
    /***
     * 孩子节点
     */
    val childNodes = mutableListOf<JsonNode>()
    var value: String? = null

    init {
        parentNode?.childNodes?.add(this)
    }

    constructor(className: String) : this(null, className, FieldType.OBJECT, 0)

    fun isRootNode(): Boolean = null == parentNode

    override fun toString(): String {
        var stringValue: String = String()
        if (FieldType.OBJECT != type && FieldType.LIST_OBJECT != type && FieldType.LIST_ITEM != type) {
            stringValue += "\"$name\" : \"$value\""
        } else if (FieldType.LIST_ITEM == type) {
            stringValue += "\"$name\""
        } else {
            stringValue += "\"$name\"(${childNodes.size})"
        }
        return stringValue
    }

}