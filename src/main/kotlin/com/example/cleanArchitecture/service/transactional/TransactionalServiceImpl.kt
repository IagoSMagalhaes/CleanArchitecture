package com.example.cleanArchitecture.service.transactional

import com.example.cleanArchitecture.entities.dto.request.RequestPostTransactionalEntity
import com.example.cleanArchitecture.entities.dto.response.PostTransactionalAccountEntity
import com.example.cleanArchitecture.entities.dto.response.PostTransactionalValidationEntity
import com.example.cleanArchitecture.entities.dto.response.ResponsePostTransactionalEntity
import com.example.cleanArchitecture.service.transactional.validator.RulesPostTransactional
import jdk.nashorn.internal.runtime.logging.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
@Logger
class TransactionalServiceImpl(val rulesPostTransactional: RulesPostTransactional) : TransactionalService {

	val LOG = LoggerFactory.getLogger(TransactionalServiceImpl::class.java)


	override fun post(body: RequestPostTransactionalEntity): ResponsePostTransactionalEntity {

		val messageValidations = rulesPostTransactional.validate(body)

		val account = PostTransactionalAccountEntity(true,body.account.limit)

		if(messageValidations.isEmpty()){
			account.availableLimit = body.account.limit - body.transactional.amount
		}

		val validations = PostTransactionalValidationEntity(messageValidations)

		return ResponsePostTransactionalEntity(account, validations)

	}



}