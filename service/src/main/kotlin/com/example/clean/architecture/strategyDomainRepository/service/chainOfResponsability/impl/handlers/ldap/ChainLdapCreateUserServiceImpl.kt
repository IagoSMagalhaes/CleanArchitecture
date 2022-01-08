package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.ldap

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.toRequestPostLdapUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.ldap.GatewayLdapUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.ChainCreateUserHandlerService
import com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers.notify.ChainCreateUserHandlerNotify
import org.springframework.stereotype.Service


@Service
class ChainCreateUserHandlerLdap(val gatewayLdapUserRepository: GatewayLdapUserRepository,
								 val chainNotify: ChainCreateUserHandlerNotify
) : ChainCreateUserHandlerService {

	override fun execute(body: RequestPostUserEntity)
			= gatewayLdapUserRepository.post(body.toRequestPostLdapUserEntity())
										 .also { next(body) }

	override fun next(body: RequestPostUserEntity) = chainNotify.execute(body)
}