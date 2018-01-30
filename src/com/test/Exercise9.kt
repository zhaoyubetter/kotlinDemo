package cz.sample.exercises

/**
 * Created by cz on 2018/1/19.
 * 金额大小写转换
 */
val unit1=arrayOf("","万","亿","万亿","兆","万兆","亿兆")
val unit2= arrayOf("","十","百","千")
val textArray=arrayOf("零","壹","二","三","四","伍","陆","柒","八","玖")
fun main(args: Array<String>) {
    //println(convert("101000201005"))
    println(convert("2550"))
}

// 大单位是4位一进,小单位是十/百/千
fun convert(text:String):String{
    var out=String()
    val array=text.toCharArray().reversed()
    var lastItem:Char?=null
    var u1=unit1[0]
    var u2=unit2[0]
    array.forEachIndexed{ index, c ->
        if(0==index % 4){
            //大单位更变
            u1=unit1[index/4]
        } else {
            //小单位更变
            u2=unit2[index % 4]
        }
        val number=textArray[c-'0']
        if('0'!=c){
            out=number+u2+out
        } else if('0'!=lastItem){
            out=number+out
        }
        //附加大单位
        if(0==index % 4){
            out=u1+out
        }
        lastItem=c
    }
    return out+"元"
}