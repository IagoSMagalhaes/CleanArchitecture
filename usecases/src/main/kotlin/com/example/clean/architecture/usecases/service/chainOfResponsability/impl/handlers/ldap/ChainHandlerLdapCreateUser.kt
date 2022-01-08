package com.example.clean.architecture.usecases.service.chainOfResponsability.impl.handlers.ldap

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.toRequestPostLdapUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.ldap.GatewayLdapUserRepository
import com.example.clean.architecture.usecases.service.chainOfResponsability.impl.handlers.ChainHandlerCreateUserService
import com.example.clean.architecture.usecases.service.chainOfResponsability.impl.handlers.notify.ChainHandlerNotifyCreateUser
import org.springframework.stereotype.Service


@Service
open class ChainHandlerLdapCreateUser(val gatewayLdapUserRepository: GatewayLdapUserRepository,
									  val chainNotify: ChainHandlerNotifyCreateUser
) : ChainHandlerCreateUserService {

	override fun execute(body: RequestPostUserEntity)
			= gatewayLdapUserRepository.post(body.toRequestPostLdapUserEntity())
										 .also { next(body) }

	override fun next(body: RequestPostUserEntity) = chainNotify.execute(body)
}