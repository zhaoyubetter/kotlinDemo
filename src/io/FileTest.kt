package io

import java.io.File
import java.util.regex.Pattern

/**
 * Created by zhaoyu1 on 2017/7/21.
 */
fun main(args: Array<String>) {
//    val filePath = "D:\\jd\\RecyclerViewLib\\app\\src\\main\\res\\values\\strings.xml"
    val filePath = "D:\\strings_ui.xml"
    val file = File(filePath)

    // <string name="app_name">RecyclerViewLib</string>

     val data = mutableListOf<RowData>()
    file.forEachLine { it ->
        get(it,data)
    }

     ExcelOperator.createExcel("D://strings22.xlsx", data)

}


// 正则表达式
val patStr = "([\"'](.*?)[\"']>)(.*?)</[sS]" // 非贪婪
val pattern = Pattern.compile(patStr)

// 生成excel
fun get(str: String, data:MutableList<RowData>) {
    val matcher = pattern.matcher(str)
    while (matcher.find()) {
        //print(matcher.group(2) + "->" + matcher.group(3) + "\n")
        data.add(RowData(matcher.group(2), matcher.group(3)))
    }
}