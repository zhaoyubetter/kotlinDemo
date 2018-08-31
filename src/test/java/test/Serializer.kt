package test

import com.better.json.data.City
import com.better.json.data.County
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

fun serialize(obj : Any) = buildString { serializeObj(obj) }

private inline fun StringBuilder.serializeObj(obj: Any) {
    // 1.获取类的所有 KProperty
    obj.javaClass.kotlin.memberProperties.joinToStringBuilder(this, separator=",",
            prefix="{", postfix="}") {
        // 2.遍历 KProperty 集合，获取每个 KProperty；
        serializePropery(it, obj)
    }
    // 3.每个KProperty都有他的名字与值，对应json的 key，value，value 处理时，需进行类型判断；
}

private inline fun StringBuilder.serializePropery(propery: KProperty1<Any, *>,
                                                  receiver: Any) {
    val jsonKey = propery.name
    serializeString(jsonKey)
    append(":")

    val jsonValue = propery.get(receiver)
    serializeValue(jsonValue)
}

private fun StringBuilder.serializeValue(jsonValue:Any?) {
    when(jsonValue) {
        null -> append("null")      // boolean , int, long, float
        is String -> serializeString(jsonValue)
        is Number -> append(jsonValue.toString())
        is Collection<*> ->  serializeCollection(jsonValue)
        is Map<*, *> -> {
            // TODO
        }
        else -> serializeObj(jsonValue)
    }
}

private inline fun StringBuilder.serializeCollection(list: Collection<*>) {
    // [Object, Object]
    list.joinToStringBuilder(this, separator=",",
            prefix="[", postfix="]") {
        serializeValue(it)
    }
}

private inline fun StringBuilder.serializeString(value:String) {
    append("\"").append(value).append("\"")
}


// 这里对joinToString 进行了改写，使其支持 ((T) -> Unit)
fun <T> Collection<T>.joinToStringBuilder(sb: StringBuilder, separator: CharSequence = ", ",
                                        prefix: CharSequence = "",
                                        postfix: CharSequence = "",
                                        limit: Int = -1,
                                        truncated: CharSequence = "...",
                                        transform: ((T) -> Unit)? = null): StringBuilder {
    return joinTo(sb, separator, prefix, postfix, limit, truncated) {
        if (transform == null) {    // 包装器模式
            return@joinTo it.toString()
        }
        transform.invoke(it)
        ""
    }
}

fun main(args: Array<String>) {
    val c = County("湘潭县", 20)
    val b = County("株洲县", 20)
    val city = City("湘潭", listOf(c, b))
    println(serialize(city))
}