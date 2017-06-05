package cz.model.plugin.json

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import cz.json.JsonNode
import cz.model.FieldType
import cz.model.*

/**
 * Created by cz on 2017/5/24.
 * 格式化json
 */
class JsonFormatter(fileName: String, val value: String, init: Boolean = false) {
    val TAG_START = 1
    val TAG_END = 2
    val TAG_LIST_START = 3
    val TAG_LIST_END = 4
    val TAG_EMPTY_LIST = 5
    val TAG_CHILD = 6
    val root: JsonNode = JsonNode(fileName)
    val singleRoot: JsonNode = JsonNode(fileName)

    init {
        if (init && isJson()) {
            eachJsonObject(1, JsonParser().parse(value).asJsonObject, this.root, this.singleRoot)
        }
    }

    fun isJson(): Boolean {
        var result = false
        try {
            val jsonElement = JsonParser().parse(value)
            result = (jsonElement.isJsonArray || jsonElement.isJsonObject)
        } catch (e: Exception) {
            result = false
        }
        return result
    }

    /**
     * 重新格式化json文本
     */
    fun format(): String {
        var out = StringBuilder()
        val spaceLength = 4
        eachJsonDom(root) { node, tag ->
            out.append("".padEnd(node.level * spaceLength, ' '))
            when (tag) {
                TAG_LIST_START -> out.append("\"${node.name}\":[\n")
                TAG_LIST_END -> out.append("]\n")
                TAG_EMPTY_LIST -> out.append("\"${node.name}\" : []\n")
                TAG_START -> {
                    if (FieldType.OBJECT == node.type) {
                        var leftBlock = if (0 != node.childNodes.size) "{" else ""
                        out.append("\"${node.name}\"$leftBlock\n")
                    } else if (FieldType.LIST_ITEM == node.type) {
                        out.delete(out.length - spaceLength, out.length)
                        out.append("{\n")
                    }
                }
                TAG_END -> {
                    if (FieldType.LIST_ITEM == node.type) {
                        out.delete(out.length - spaceLength, out.length)
                    }
                    var rightBlock = if (0 != node.childNodes.size) "}" else ""
                    out.append("$rightBlock\n")
                }
                TAG_CHILD -> out.append("\"${node.name}\" : \"${node.value}\"\n")
            }
        }
        return out.toString()
    }


    /**
     * 遍历节点
     */
    fun eachJsonDom(dom: JsonNode, closure: (JsonNode, Int) -> Unit) {
        if (dom.childNodes.isEmpty()) {
            closure.invoke(dom, if (FieldType.LIST_OBJECT == dom.type) TAG_EMPTY_LIST else TAG_CHILD)
        } else {
            closure.invoke(dom, if (FieldType.LIST_OBJECT == dom.type) TAG_LIST_START else TAG_START)
            dom.childNodes.forEach { eachJsonDom(it, closure) }
            closure.invoke(dom, if (FieldType.LIST_OBJECT == dom.type) TAG_LIST_END else TAG_END)
        }
    }

    /**
     * 遍历json
     */
    fun eachJsonObject(level: Int, item: JsonObject, parentNode: JsonNode, singleParentNode: JsonNode) {
        val sets = item.entrySet().iterator()
        for (entry in sets) {
            val key = entry.key
            val childItem = item.get(key)                                       // gson 这里就是 jsonElement
            var fieldType = getFieldType(childItem, parentNode)                 // 获取类型
            var childNode = JsonNode(parentNode, key, fieldType, level + 1)     // 创建自定义的JsonNode 类

            // 从父节点中遍历子节点，是否有相同的子节点
            var childSingleNode = singleParentNode.childNodes.find { it.name == key }
            if (null == childSingleNode) {
                childSingleNode = JsonNode(parentNode = singleParentNode,
                        name = key, type = fieldType, level = level + 1)     // 创建节点
            } else if (FieldType.UN_KNOW == childSingleNode.type) {     // 有些list节点，返回如：[]的类型，更正类型
                //判断子条目类型是否与父条目设定类型一致,
                //此处原因为:有的数组无数据,所以给定默认类型,此处判断其他数据列,是否有数据,并重新设定类型
                childSingleNode.type = getFieldType(childItem, singleParentNode)
            }

            // 设置 JsonNode 值
            eachAnyItem(level, childItem, childNode, childSingleNode)
        }
    }

    /**
     * @param level
     * @param item
     * @param parentNode
     * @param singleParentNode
     */
    fun eachAnyItem(level: Int, item: Any, parentNode: JsonNode, singleParentNode: JsonNode) {
        if (item is JsonArray) {        // 判断类型
            (0..item.size() - 1).map { item.get(it) }.forEach { item ->
                if (item is JsonObject) {
                    var fieldType = getFieldType(item, parentNode)
                    val itemNode = JsonNode(parentNode, parentNode.name, fieldType, level + 1)
                    eachJsonObject(level + 1, item, itemNode, singleParentNode)     // 这里递归
                } else {
                    parentNode.value = item.toString()      // 设置 node value值
                    singleParentNode.value = item.toString()
                }
            }
        } else if (item is JsonObject) {
            eachJsonObject(level + 1, item, parentNode, singleParentNode)       // 递归走
        } else {
            parentNode.value = item.toString()       // 设置node value值
            singleParentNode.value = item.toString()
        }
    }

    /**
     * 获取类型
     */
    fun getFieldType(item: Any, parentNode: JsonNode): FieldType {
        val fieldItem: FieldType
        when (item) {
            is Byte -> fieldItem = FieldType.BYTE
            is Char -> fieldItem = FieldType.CHAR
            is Short -> fieldItem = FieldType.SHORT
            is Float -> fieldItem = FieldType.FLOAT
            is Double -> fieldItem = FieldType.DOUBLE
            is Long -> fieldItem = FieldType.LONG
            is Integer -> fieldItem = FieldType.INT
            is Boolean -> fieldItem = FieldType.BOOLEAN
            // 自己是 {}, 父是否是 []
            is JsonObject -> if (FieldType.LIST_OBJECT == parentNode.type)
                fieldItem = FieldType.LIST_ITEM else fieldItem = FieldType.OBJECT
            is JsonArray -> {
                if (0 == item.size()) {
                    fieldItem = FieldType.UN_KNOW
                } else {
                    // val itemValue = item.opt(0)
                    val itemValue = item.get(0)     // 拿到第一个item (jsonElement)
                    when (itemValue as Any) {
                        is Integer -> fieldItem = FieldType.LIST_INTEGER
                        is Boolean -> fieldItem = FieldType.LIST_BOOLEAN
                        is Double -> fieldItem = FieldType.LIST_DOUBLE
                        is Long -> fieldItem = FieldType.LIST_LONG
                        is String -> fieldItem = FieldType.LIST_STRING
                        else -> fieldItem = FieldType.LIST_OBJECT
                    }
                }
            }
            else -> fieldItem = FieldType.STRING
        }
        return fieldItem
    }

    fun getJsonClassItem(): List<ClassItem> {
        //获取每一个可单独生成class的条目信息
        val items = mutableListOf<ClassItem>()
        eachJsonDom(singleRoot) { node, tag ->
            if (TAG_START == tag || TAG_LIST_START == tag) {
                if (null == items.find { it.nodeName == node.name }) {
                    items.add(getClassItem(node))
                }
            }
        }
        return items
    }

    fun getClassItem(node: JsonNode): ClassItem {
        return getClassItem(node) { getClassName(it.name) }
    }

    fun getClassItem(node: JsonNode, closure: (JsonNode) -> String): ClassItem {
        var fieldItems = mutableListOf<ClassField>()
        val className = getClassName(node.name)
        node.childNodes.forEach { fieldItems.add(ClassField(closure.invoke(it), it.name, it.type)) }
        return ClassItem(node.name, className, fieldItems, true)
    }

    /**
     * 生成java风格的类命名
     */
    fun getClassName(name: String): String {
        return name.split("_").map { it[0].toUpperCase() + it.substring(1..it.length - 1) }.reduce { acc, s -> acc + s }
    }

}

