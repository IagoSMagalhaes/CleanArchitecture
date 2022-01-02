package com.example.clean.architecture.strategyDomainRepository.service.impl

import com.example.clean.architecture.entities.domain.domain.DomainEntity
import com.example.clean.architecture.strategyDomainRepository.strategy.factory.StrategyDomainFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
open class DomainServiceImpl(val factory: StrategyDomainFactory) {

	 val LOG = LoggerFactory.getLogger(DomainServiceImpl::class.java)


	fun get(domain: String, query: String?) : List<DomainEntity> {

		LOG.info("START GET Domain domain: {} query: {}", domain, query)

		val strategy = factory.get(domain)

		LOG.info("GET Domain strategy: {} service: {}", strategy?.domain, strategy?.service.toString())

		val response = strategy?.get(domain, query)

		LOG.info("GET Domain strategy: {} response: {}", strategy?.domain, response)

		return response.orEmpty()
	}

}