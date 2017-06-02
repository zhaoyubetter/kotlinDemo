package inner_class

import java.io.Serializable

/**
 * 内部类，嵌套类
 * Created by zhaoyu1 on 2017/6/2.
 */
interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
    }

    // inner class
    class ButtonState : State {
    }
}
