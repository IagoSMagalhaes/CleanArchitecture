package com.example.clean.architecture.controller.listener.notify

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.crm.GatewayNotifyCreateUserCRMRepository
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.producer.GatewayProducerNotifyCreateUserRepository
import org.slf4j.LoggerFactory
import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Controller


@Controller
open class NotifyCreateUserCRMListener(val gatewayNotifyCRMRepository: GatewayNotifyCreateUserCRMRepository) {

    val LOG = LoggerFactory.getLogger(NotifyCreateUserCRMListener::class.java)

	@RabbitListener(queues = ["NotifyCreateUserCRM.INP"])
	fun onMessage(body: RequestPostNotifyCreateUserCRMEntity){

        val method = "NotifyCreateUserCRMListener"

        runCatching {

            LOG.info("START RABBIT $method message: ")

            gatewayNotifyCRMRepository.notifyCRM(body)

        }.onFailure {

            LOG.error("ERROR RABBIT $method  message: ${it.message} localizedMessage: ${it.localizedMessage}" )

            throw AmqpRejectAndDontRequeueException(it.message)

        }.onSuccess {

            LOG.info("END RABBIT $method ")
        }
	}
}

