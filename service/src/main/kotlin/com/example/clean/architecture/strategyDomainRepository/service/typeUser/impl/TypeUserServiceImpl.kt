package com.example.clean.architecture.strategyDomainRepository.service.typeUser.impl

import com.example.clean.architecture.entities.typeUser.domain.TypeUserEntity
import com.example.clean.architecture.entities.typeUser.exception.TypeUserGetException
import com.example.clean.architecture.repository.typeUser.domain.TypeUser
import com.example.clean.architecture.repository.typeUser.domain.toEntity
import com.example.clean.architecture.repository.typeUser.repository.TypeUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.typeUser.TypeUserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class TypeUserServiceImpl(val repository: TypeUserRepository) : TypeUserService {

	 val LOG = LoggerFactory.getLogger(TypeUserServiceImpl::class.java)

	override open fun get() : List<TypeUserEntity> {

		LOG.info("START GET TypeUser")

		var response = emptyList<TypeUser>()

		runCatching {

			response = repository.findAll()

		}.onFailure {

			LOG.error("ERROR GET TypeUser message: {} causeMessage: {}", it.message, it.cause?.message)

			throw TypeUserGetException()

		}.onSuccess {

			LOG.info("END GET TypeUser response: {}", response)

		}

		return response.toEntity()
	}

	}


