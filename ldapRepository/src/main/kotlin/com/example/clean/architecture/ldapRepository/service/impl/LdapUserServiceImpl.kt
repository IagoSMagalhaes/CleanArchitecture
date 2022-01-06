package com.example.clean.architecture.ldapRepository.service.impl

import com.example.clean.architecture.entities.otherRepositories.ldap.user.domain.LdapUserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.exception.LdapUserGetException
import com.example.clean.architecture.entities.otherRepositories.ldap.user.exception.LdapUserPostException
import com.example.clean.architecture.ldapRepository.repository.ldapUser.domain.LdapUser
import com.example.clean.architecture.ldapRepository.repository.ldapUser.domain.toDomain
import com.example.clean.architecture.ldapRepository.repository.ldapUser.domain.toEntity
import com.example.clean.architecture.ldapRepository.repository.ldapUser.repository.LdapUserRepository
import com.example.clean.architecture.ldapRepository.service.LdapUserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class LdapUserServiceImpl(val repository: LdapUserRepository) : LdapUserService {

	 val LOG = LoggerFactory.getLogger(LdapUserServiceImpl::class.java)


	override fun get(): List<LdapUserEntity> {

		val methodName = "LDAP GET ALL"

		var response = emptyList<LdapUser>()

		runCatching {

			LOG.info("START $methodName")

			response = repository.findAll() as List<LdapUser>

		}.onFailure {

			LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw LdapUserGetException()

		}.onSuccess {
			LOG.info("END $methodName")

		}

		return response.toEntity()
	}

	override fun get(document: String): LdapUserEntity? {
		val methodName = "LDAP GET by Document"

		var response: LdapUser? = null

		runCatching {

			LOG.info("START $methodName document $document")

			response = repository.findByName(document) as LdapUser

		}.onFailure {

			LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw LdapUserGetException()

		}.onSuccess {
			LOG.info("END $methodName")

		}

		return response?.toEntity()
	}

	override fun post(body: RequestPostLdapUserEntity) {

		val methodName = "LDAP POST USER"

		runCatching {

			LOG.info("START $methodName body: $body")

			val ldapUser = body.toEntity().toDomain()

			repository.save(ldapUser)

		}.onFailure {

			LOG.error("ERROR $methodName message: {} localizeMessage: {}", it.message, it.localizedMessage)

			throw LdapUserPostException()

		}.onSuccess {
			LOG.info("END $methodName")

		}
	}
}


