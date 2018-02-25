package three

/**
 * Created by zhaoyu on 2017/5/29.
 */
// 集成
class Class1(p: Int, override val x: Int) : Base(p) {

    var name: String
        get() = this.toString()
        private set     // 私有

    var street: String = ""
        get() = this.toString()
        set(value) {
            if(value.length > 0) {
                field = value       // 幕后字段 field
            }
        }
    var city: String

    init {
        name = ""
        street = ""
        city = ""
    }

    // 继承属性 或者在构造中写
    // override val x: Int = 0

    override fun v() {
        super.v()
    }
}