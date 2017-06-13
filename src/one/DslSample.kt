package one

/**
 * Created by zhaoyu1 on 2017/6/10.
 */
val closure:()->Unit={

}
fun main(args: Array<String>) {
    login { v1,v2->
        false
    }


//    val android = android {
//        debug {
//            name = "xxx"
//            packageName = "com..."
//        }
//
//        buildType {
//
//        }
//    }
//    println(android.application?.name)



}
fun login(closure:(String,Int)->Boolean){
    closure.invoke("it",12)
}

fun android(action:Config.()->Unit)=Config().apply(action)

class Config{
    var application:Applicatoin?=null
    fun debug(action:Applicatoin.()->Unit){
        application=Applicatoin().apply(action)
    }
    fun buildType(action:()->Unit)=action.invoke()
}

class Applicatoin{
    var name:String?=null
    var packageName:String?=null
}
