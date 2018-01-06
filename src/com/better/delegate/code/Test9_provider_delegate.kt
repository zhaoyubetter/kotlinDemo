package com.better.delegate.code

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * 提供委托
 * 不懂，跳过
 * http://www.runoob.com/kotlin/kotlin-delegated.html
 * Created by zhaoyu on 2018/1/1.
 */
class ResourceID {
    val image_id :String = "101"
    val text_id :String = "102"
}

class ResourceLoader(id:ResourceID) {
    val d:ResourceID = id

    operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>) : ReadOnlyProperty<MyUI, String> {
        if(checkProperty(thisRef, prop.name)){
            return DellImpl(d)
        }else{
            throw Exception("Error ${prop.name}")
        }
    }

    private fun checkProperty(thisRef: MyUI, name: String):Boolean {
        return name == "image" || name == "text"
    }
}

class DellImpl(d: ResourceID) : ReadOnlyProperty<MyUI,String>{
    val id: ResourceID = d
    override  fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        return if(property.name == ("image"))
            property.name + "  " + id.image_id
        else
            property.name + "  " + id.text_id
    }
}

fun  bindResource(id: ResourceID): ResourceLoader {
    var res = ResourceLoader(id)
    return res
}

class MyUI {
    val image by bindResource(ResourceID())
    val text by bindResource(ResourceID())
    //val webview by bindResource(ResourceID())
}

fun main(args: Array<String>) {
    var ui = MyUI()
    println(ui.image)
    println(ui.text)
}
