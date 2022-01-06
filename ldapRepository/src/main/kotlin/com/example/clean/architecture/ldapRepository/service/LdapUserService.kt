package com.example.clean.architecture.ldapRepository.service

import com.example.clean.architecture.entities.otherRepositories.ldap.user.domain.LdapUserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity


interface LdapUserService {

	fun get() : List<LdapUserEntity>

	fun get(document: String) : LdapUserEntity?

	fun post(body: RequestPostLdapUserEntity)
}