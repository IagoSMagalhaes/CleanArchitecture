package com.example.clean.architecture.strategyDomainRepository.service.impl

import com.example.clean.architecture.entities.otherRepositories.domain.domain.DomainEntity
import com.example.clean.architecture.strategyDomainRepository.strategy.factory.StrategyDomainFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class DomainUsecaseImpl(val factory: StrategyDomainFactory) {

	 val LOG = LoggerFactory.getLogger(DomainUsecaseImpl::class.java)

	fun getV2(domain: String, query: String?) : List<DomainEntity> {
		return factory.get(domain).get(domain, query)
	}

	fun get(domain: String, query: String?) : List<DomainEntity> {

		var response: List<DomainEntity> = emptyList()

		runCatching {
			LOG.info("START GET Domain domain: {} query: {}", domain, query)

			val strategy = factory.get(domain)

			LOG.info("GET Domain strategy: {} service: {}", strategy.domain, strategy.service.toString())

			response = strategy.get(domain, query)

			LOG.info("GET Domain strategy: {} response: {}", strategy.domain, response)

		}.onFailure {
			LOG.info("ERROR GET Domain domain: {} query: {} message: {} localizedMessage: {}", domain, query, it.message, it.localizedMessage)
		}

		return response
	}
}