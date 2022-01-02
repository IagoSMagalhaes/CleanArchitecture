package com.example.clean.architecture.strategyDomainRepository.strategy.factory

import com.example.clean.architecture.strategyDomainRepository.service.impl.DomainServiceImpl
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.AbstractStrategyDomain
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.LinkedMultiValueMap


@Configuration
open class StrategyDomainFactory() {

	var strategies: LinkedMultiValueMap<String, AbstractStrategyDomain> = LinkedMultiValueMap<String, AbstractStrategyDomain>();

	val LOG = LoggerFactory.getLogger(DomainServiceImpl::class.java)

	@Bean
	open fun createStrategyDomain(domains: List<AbstractStrategyDomain>): Boolean {

		val methodName = "createStrategyDomain"

		LOG.info("START $methodName size: ${domains.size} strategies: ${domains.map { it.service.toString()}}")

		domains.forEach{ _strategy ->

			_strategy.registerStrategy().forEach { _domain ->

				strategies.add(_domain, _strategy)
			}
		}


		LOG.info("END $methodName size: ${strategies.size} strategies: ${strategies.map { it.value.toString()}}")


		return true;
	}

	fun get(domain: String): AbstractStrategyDomain {

		LOG.info("START Factory strategy domain: $domain")

		val response = strategies[domain]!!.first()

		LOG.info("END Factory strategy domain: $response")

		return response
	}

}