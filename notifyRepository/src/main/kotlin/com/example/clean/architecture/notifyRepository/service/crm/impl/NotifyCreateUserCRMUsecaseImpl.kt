package com.example.clean.architecture.notifyRepository.service.crm.impl

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity
import com.example.clean.architecture.entities.otherRepositories.notify.exception.PostNotifyCreateUserException
import com.example.clean.architecture.notifyRepository.client.CRMClient
import com.example.clean.architecture.notifyRepository.service.crm.NotifyCreateUserCRMUsecase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class NotifyCreateUserCRMUsecaseImpl() : NotifyCreateUserCRMUsecase {

	 val LOG = LoggerFactory.getLogger(NotifyCreateUserCRMUsecaseImpl::class.java)


	override fun notifyCRM(body: RequestPostNotifyCreateUserCRMEntity) {

		val methodName = "Produce Notify Create User"

		runCatching {

			LOG.info("START $methodName body: $body")

			//client.notifyCRM(body)

		}.onFailure {

			LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw PostNotifyCreateUserException()

		}.onSuccess {
			LOG.info("END $methodName")

		}
	}
}


