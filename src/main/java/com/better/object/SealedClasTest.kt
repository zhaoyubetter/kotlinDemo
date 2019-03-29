package cz.sample.kotlin.com.better.`object`

/**
 * sealed test¬
 */
sealed class SuperCommand {
    object UP : SuperCommand()
    object DOWN : SuperCommand()
    class PACE(var pace: Int) : SuperCommand() {
        fun `do`() {
            println("ok")
        }
    }
}

fun exex(u: Any, cmd: SuperCommand) {
    when (cmd) {
        SuperCommand.UP -> {

        }

        is SuperCommand.PACE -> {
            cmd.`do`()
        }
    }
}