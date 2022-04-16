package com.example.clean.architecture.notifyRepository.service.producer.impl

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity
import com.example.clean.architecture.entities.otherRepositories.notify.exception.PostNotifyCreateUserException
import com.example.clean.architecture.notifyRepository.service.producer.ProducerNotifyCreateUserUsecase
import com.sun.org.slf4j.internal.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class ProducerNotifyCreateUserUsecaseImpl() : ProducerNotifyCreateUserUsecase {

	 val LOG = LoggerFactory.getLogger(ProducerNotifyCreateUserUsecaseImpl::class.java)


	override fun produce(body: RequestPostNotifyCreateUserEntity) {

		val methodName = "Produce Notify Create User"

		runCatching {

			//LOG.info("START $methodName body: $body")

			//rabbitTemplate.send("routingkey", body)

		}.onFailure {

			//LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw PostNotifyCreateUserException()

		}.onSuccess {
			//LOG.info("END $methodName")

		}
	}
}


