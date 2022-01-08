package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.notify

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.toRequestPostNotifyCreateUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.GatewayProducerNotifyCreateUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.ChainHandlerCreateUserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class ChainHandlerNotifyCreateUser(val gatewayProducerNotifyCreateUserRepository: GatewayProducerNotifyCreateUserRepository
) : ChainHandlerCreateUserService {

	val LOG = LoggerFactory.getLogger(ChainHandlerNotifyCreateUser::class.java)

	override fun execute(body: RequestPostUserEntity) =
						gatewayProducerNotifyCreateUserRepository.produce(body.toRequestPostNotifyCreateUserEntity())
																	.also { next(body) }

	override fun next(body: RequestPostUserEntity) =
		LOG.info("END Flux ChainOfResponsabilityCreateUser user ${body.name}")

}