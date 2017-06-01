package regex

/**
 * Created by zhaoyu1 on 2017/6/1.
 */
fun main(args: Array<String>) {
    val str = "12.345-6.a"
    println(str.split(".","-"))

    val path:String = "/Users/better/android/kotlin-book.pdf"
    parsePath(path)

    println("使用 Kotlin正则支持")
    parsePathRegex(path)
}

// 使用字符串截取方式
fun parsePath(path:String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfter(".")
    println("Dir:$directory, FullName:$fullName, FileName:$fileName, Extension:$extension")
}

// 使用正则
fun parsePathRegex(path:String) {
    val regex = """(.+)/((.+)\.(.+))""".toRegex()       // 三引号
    val matchResult = regex.matchEntire(path)
    if(matchResult != null) {
        val(directory, fullName, fileName, extension) = matchResult.destructured
        println("Dir:$directory, FullName: $fullName, FileName:$fileName, Extension:$extension")
    }
}