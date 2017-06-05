package com.cz.model.plugin.model

/**
 * Created by cz on 2017/5/26.
 */
data class ClassItem(val nodeName:String,val className:String,val fieldItems:List<ClassField>,var serializer:Boolean){
    var newClassName:String = className
    var singleFile:Boolean=true
}