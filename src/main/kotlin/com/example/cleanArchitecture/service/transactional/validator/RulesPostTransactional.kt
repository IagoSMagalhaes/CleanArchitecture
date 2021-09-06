package com.example.cleanArchitecture.service.transactional.validator

import com.example.cleanArchitecture.entities.dto.request.RequestPostTransactionalEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service



//

@Service
class RulesPostTransactional() {

	val LOG = LoggerFactory.getLogger(RulesPostTransactional::class.java)


	fun validate(body: RequestPostTransactionalEntity) : List<String> {

		var response = listOf<String>()

		response = response.plus(validateStatus(body.account.status))
x
		response = response.plus(validateExceedLimit90percentage(body.transactional.amount, body.account.limit))

		response = response.plus(validateInsufficientLimit(body.transactional.amount, body.account.limit))

		response = response.plus(validateHistory())

		return response
	}


	 fun validateStatus(accountStatus: String): List<String> {

		if(accountStatus.isInactive())
				return listOf("account-inactive")

		return emptyList()
	}

	fun validateExceedLimit90percentage(transactionalValue: Long, limit: Long): List<String> {


		//TODO - INCLUIR REGRA SOMENTE PARA A PRIMEIRO
		val limitDividioPor100 = limit / 100
		val noventaPorcentoLimit = limitDividioPor100 * 90

		if(transactionalValue > noventaPorcentoLimit)
			return listOf("first-transaction-above-threshold")

		return emptyList()
	}

	fun validateInsufficientLimit(transactionalValue: Long, limit: Long) : List<String> {

		if(transactionalValue > limit)
				return listOf("insuficient-limit")

		return emptyList()
	}




	fun validateHistory() : List<String> {

		var response = listOf<String>()

		response = validateCurrentFrequencyHistory()
		response = response.plus(validateCurrentDuplicateHistory())

		return response
	}

	fun validateCurrentFrequencyHistory() : List<String> {

		return emptyList()

	}

	fun validateCurrentDuplicateHistory() : List<String> {
		return emptyList()
	}




}



//TODO - EVOLUIR pro Enum
fun String.isInactive() = this == "inactive"



