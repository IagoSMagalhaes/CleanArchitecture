package com.example.clean.architecture.ldapRepository.gateway

import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.ldap.GatewayLdapUserRepository
import com.example.clean.architecture.ldapRepository.service.LdapUserService
import org.springframework.stereotype.Service


@Service
open class GatewayLdapUserServiceImpl(val service: LdapUserService) : GatewayLdapUserRepository {

	override fun get() = service.get()

	override fun get(document: String) = service.get(document)

	override fun post(body: RequestPostLdapUserEntity) = service.post(body)
}


