package com.example.cleanArchitecture.service.domain.service.impl

import com.example.cleanArchitecture.service.domain.strategy.factory.StrategyDomainFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class DomainServiceImpl(val factory: StrategyDomainFactory) {

	val LOG = LoggerFactory.getLogger(DomainServiceImpl::class.java)


	fun get(domain: String, query: String?) =
		factory.getStrategy(domain).get(domain, query)

}