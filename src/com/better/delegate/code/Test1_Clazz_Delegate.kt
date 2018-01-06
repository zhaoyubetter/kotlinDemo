package com.better.delegate.code

/**
 * 委托类例子
 */

interface TicketCenter {
    fun sellTrainTicket()
}

class TrainStation : TicketCenter {
    override fun sellTrainTicket() {
        println("TrainStation sell ticket")
    }
}

class JdTicketBiz(ticketCenter: TicketCenter) : TicketCenter by ticketCenter

fun main(args: Array<String>) {
    val trainStation = TrainStation()
    JdTicketBiz(trainStation).sellTrainTicket()
}