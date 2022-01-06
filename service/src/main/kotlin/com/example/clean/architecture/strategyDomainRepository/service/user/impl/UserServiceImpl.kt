package com.example.clean.architecture.strategyDomainRepository.service.user.impl

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestGetUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.toEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.exception.UserDeleteException
import com.example.clean.architecture.entities.cleanArchitecture.user.exception.UserGetException
import com.example.clean.architecture.entities.cleanArchitecture.user.exception.UserPostException
import com.example.clean.architecture.entities.cleanArchitecture.user.exception.UserPutException
import com.example.clean.architecture.gatewayRepository.otherRepositories.ldap.GatewayLdapUserRepository
import com.example.clean.architecture.repository.user.domain.User
import com.example.clean.architecture.repository.user.domain.toDomain
import com.example.clean.architecture.repository.user.domain.toEntity
import com.example.clean.architecture.repository.user.domain.toRequestPostLdapUserEntity
import com.example.clean.architecture.repository.user.repository.UserRepository
import com.example.clean.architecture.strategyDomainRepository.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*


@Service
open class UserServiceImpl(val repository: UserRepository,
							val gatewayLdapUserRepository: GatewayLdapUserRepository) : UserService {

	 val LOG = LoggerFactory.getLogger(UserServiceImpl::class.java)

	override fun get() : List<UserEntity> {

		LOG.info("START GET User")

		var response = emptyList<User>()

		runCatching {

			response = repository.findAll()

		}.onFailure {

			LOG.error("ERROR GET User message: {} causeMessage: {}", it.message, it.cause?.message)

			throw UserGetException()

		}.onSuccess {

			LOG.info("END GET User response: {}", response)

		}

		return response.toEntity()
	}

	override fun getBy(body: RequestGetUserEntity): List<UserEntity> {

		LOG.info("START GET User")

		var response = emptyList<User>()

		runCatching {

			response = when {

				body.perId() -> buildPerId(body)

				body.perName() -> repository.findByNameIn(listOf(body.name!!))

				body.perCellphone() -> repository.findByCellphoneIn(listOf(body.cellphone!!))

				body.perEmail() -> repository.findByEmailIn(listOf(body.email!!))

				else -> listOf()
			}

		}.onFailure {

			LOG.error("ERROR GET User message: {} causeMessage: {}", it.message, it.cause?.message)

			throw UserGetException()

		}.onSuccess {

			LOG.info("END GET User response: {}", response)

		}

		return response.toEntity()
	}

	private fun buildPerId(body: RequestGetUserEntity): List<User> {
		val user = repository.findById(body.id!!)

		return getIsPresent(user)
	}


	private fun getIsPresent(user: Optional<User>): List<User> {
		return if (user.isPresent) {
			listOf(user.get())
		} else {
			listOf()
		}
	}

	override fun post(body: RequestPostUserEntity) {

		LOG.info("START POST User body: {}", body)

		runCatching {

			val domain = body.toEntity().toDomain()

			repository.save(domain)

			val ldap = domain.toRequestPostLdapUserEntity()

			gatewayLdapUserRepository.post(ldap)

		}.onFailure {

			LOG.error("ERROR POST User body: {} message: {} causeMessage: {}", body, it.message, it.cause?.message)

			throw UserPostException()

		}.onSuccess {

			LOG.info("END POST User")

		}
	}


	override fun put(body: RequestPutUserEntity){

		LOG.info("START PUT User body: {}", body)

		runCatching {

			val domain = body.toEntity().toDomain()

			repository.save(domain)

		}.onFailure {

			LOG.error("ERROR PUT User body: {} message: {} causeMessage: {}", body, it.message, it.cause?.message)

			throw UserPutException()

		}.onSuccess {

			LOG.info("END PUT User")

		}

	}

	override fun delete(id: Long){

		LOG.info("START DELETE User body: {}", id)

		runCatching {

			repository.deleteById(id)

		}.onFailure {

			LOG.error("ERROR DELETE User body: {} message: {} causeMessage: {}", id, it.message, it.cause?.message)

			throw UserDeleteException()

		}.onSuccess {
			LOG.info("END DELETE User")
		}
	}

		override fun getFull(id: Long) = repository.getById(id).toEntity()
	}


