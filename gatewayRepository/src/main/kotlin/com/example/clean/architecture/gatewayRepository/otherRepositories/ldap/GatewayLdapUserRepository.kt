package com.example.clean.architecture.gatewayRepository.otherRepositories.ldap

import com.example.clean.architecture.entities.otherRepositories.ldap.user.domain.LdapUserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity


interface GatewayLdapUserRepository {

	fun get() : List<LdapUserEntity>

	fun get(document: String) : LdapUserEntity?

	fun post(body: RequestPostLdapUserEntity)
}

