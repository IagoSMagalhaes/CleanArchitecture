package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.repository

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.ChainCreateUserHandlerService
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.ldap.ChainCreateUserHandlerLdap
import com.example.clean.architecture.strategyDomainRepository.service.user.UserService
import org.springframework.stereotype.Service


@Service
class ChainCreateUserHandlerRepository(val service: UserService,
									   val chainLdap: ChainCreateUserHandlerLdap
) : ChainCreateUserHandlerService {

	override fun execute(body: RequestPostUserEntity) = service.post(body)
																.also { next(body) }

	override fun next(body: RequestPostUserEntity) = chainLdap.execute(body)
}