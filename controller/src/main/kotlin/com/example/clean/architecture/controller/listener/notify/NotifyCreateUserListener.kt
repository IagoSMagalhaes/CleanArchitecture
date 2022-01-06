package com.example.clean.architecture.controller.listener.notify

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Controller


@Controller
open class NotifyCreateUserListener() {

    val LOG = LoggerFactory.getLogger(NotifyCreateUserListener::class.java)

	@RabbitListener(queues = ["NotifyCreateUser.INP"])
	fun get(){

        LOG.info("")
	}
}

