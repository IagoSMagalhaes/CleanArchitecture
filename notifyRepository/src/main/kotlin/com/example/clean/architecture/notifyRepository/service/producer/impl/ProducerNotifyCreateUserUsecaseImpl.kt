package com.example.clean.architecture.notifyRepository.service.producer.impl

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity
import com.example.clean.architecture.entities.otherRepositories.notify.exception.PostNotifyCreateUserException
import com.example.clean.architecture.notifyRepository.service.producer.ProducerNotifyCreateUserUsecase
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service


@Service
open class ProducerNotifyCreateUserUsecaseImpl(val rabbitTemplate: RabbitTemplate) : ProducerNotifyCreateUserUsecase {

	 val LOG = LoggerFactory.getLogger(ProducerNotifyCreateUserUsecaseImpl::class.java)


	override fun produce(body: RequestPostNotifyCreateUserEntity) {

		val methodName = "Produce Notify Create User"

		runCatching {

			LOG.info("START $methodName body: $body")

			//rabbitTemplate.send("routingkey", body)

		}.onFailure {

			LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw PostNotifyCreateUserException()

		}.onSuccess {
			LOG.info("END $methodName")

		}
	}
}


