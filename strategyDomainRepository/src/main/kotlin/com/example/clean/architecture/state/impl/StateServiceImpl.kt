package com.example.clean.architecture.domainRepository.state.impl

import com.example.clean.architecture.entities.domain.state.dto.request.RequestPostStateEntity
import com.example.clean.architecture.repository.domain.state.domain.State
import com.example.clean.architecture.repository.domain.state.repository.StateRepository
import org.springframework.stereotype.Service


@Service
open class StateServiceImpl(val stateRepository: StateRepository)  {

	// val LOG = LoggerFactory.getLogger(StateServiceImpl::class.java)

	fun post(body: RequestPostStateEntity) {

		//// LOG.info("START POST State " + body.fullname)

		runCatching {

			if (body.fullname == null) {
				throw Exception();
			}

			val stateSave = State(initials = body.initials, fullName = body.fullname);

			stateRepository.save(stateSave)

		}.onFailure {
			// LOG.error("ERROR POST State message: {} causeMessage: {}", it.message, it.cause!!.message)

			throw Exception()

		}.onSuccess {
		//	// LOG.info("END POST  State response: {}")

		}
	}

}