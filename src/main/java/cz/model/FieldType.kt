package cz.model

/**
 * java 类型 与 kotlin类型对应的枚举类
 * Created by cz on 2017/5/24.
 */
enum class FieldType(val java: String, val kotlin: String) {
    BYTE("byte", "Byte?"), INT("int", "Int?"),
    SHORT("short", "Short?"), FLOAT("float", "Float?"),
    DOUBLE("double", "Double?"), CHAR("char", "Char?"),
    BOOLEAN("boolean", "Boolean?"), LONG("long", "Long?"),
    STRING("String", "String?"), LIST_STRING("List<String>", "List<String?>?"),
    LIST_INTEGER("List<Integer>", "List<Int?>?"), LIST_BOOLEAN("List<Boolean>", "List<Boolean?>?"),
    LIST_DOUBLE("List<Double>", "List<Double?>?"), LIST_LONG("List<Long>", "List<Long?>?"),
    LIST_OBJECT("List<%s>", "List<%s?>?"), LIST_ITEM("Object", "%s?"), OBJECT("Object", "%s?"),
    ENUM("enum", "enum"), UN_KNOW("List<String>", "List<String?>?");

    fun getType(name: String): String {
        val type: String
        if (OBJECT == this || LIST_OBJECT == this || LIST_ITEM == this) {
            type = String.format(kotlin, name)
        } else {
            type = kotlin
        }
        return type
    }

    fun getKotlinType(fieldType: String): String? {
        var type: String? = null
        if (kotlin.startsWith("List")) {
            val matcher = "<([\\w\\.\\?]+)>".toRegex().find(fieldType)
            if (null != matcher) {
                type = matcher.groupValues[1]
            }
        }
        return type
    }

    fun getKotlinSafeType(fieldType: String): String? {
        var type: String? = null
        if (kotlin.startsWith("List")) {
            val matcher = "<([\\w\\.]+)\\??>".toRegex().find(fieldType)
            if (null != matcher) {
                type = matcher.groupValues[1]
            }
        }
        return type
    }
}

fun main(args: Array<String>) {
    println(FieldType.BOOLEAN.java)
    println(FieldType.DOUBLE.kotlin)
}
