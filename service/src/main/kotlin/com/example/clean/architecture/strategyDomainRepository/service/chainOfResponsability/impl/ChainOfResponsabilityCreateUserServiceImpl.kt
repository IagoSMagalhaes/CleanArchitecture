package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.ChainOfResponsabilityCreateUserService
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.repository.ChainHandlerRepositoryCreateUser
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class ChainOfResponsabilityCreateUserServiceImpl(val chainRepository: ChainHandlerRepositoryCreateUser) : ChainOfResponsabilityCreateUserService {

	val LOG = LoggerFactory.getLogger(ChainOfResponsabilityCreateUserServiceImpl::class.java)

	override fun execute(body: RequestPostUserEntity) {

		val methodName = "ChainOfResponsabilityCreateUser"

		runCatching {

			LOG.info("START $methodName body: $body")

			chainRepository.execute(body)

		}.onFailure {

			LOG.error("ERROR $methodName message: ${it.message} localizedMessage: ${it.localizedMessage}")

			throw it

		}.onSuccess {

			LOG.info("END $methodName")
		}

	}

}