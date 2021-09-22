package com.example.cleanArchitecture.service.state.impl

import com.example.cleanArchitecture.entities.domain.state.dto.request.RequestPostStateEntity
import com.example.cleanArchitecture.repository.state.domain.State
import com.example.cleanArchitecture.repository.state.repository.StateRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class StateServiceImpl(val stateRepository: StateRepository)  {

	val LOG = LoggerFactory.getLogger(StateServiceImpl::class.java)

	fun post(body: RequestPostStateEntity) {

		LOG.info("START POST State " + body.fullname)

		runCatching {

			if (body.fullname == null) {
				throw Exception();
			}

			val stateSave = State(initials = body.initials, fullName = body.fullname);

			stateRepository.save(stateSave)

		}.onFailure {
			LOG.error("ERROR POST State message: {} causeMessage: {}", it.message, it.cause!!.message)

			throw Exception()

		}.onSuccess {
			LOG.info("END POST  State response: {}")

		}
	}

}