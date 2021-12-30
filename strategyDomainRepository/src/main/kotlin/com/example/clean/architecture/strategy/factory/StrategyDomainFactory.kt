package com.example.clean.architecture.domainRepository.strategy.factory

import com.example.clean.architecture.domainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.LinkedMultiValueMap


@Configuration
open class StrategyDomainFactory() {

	var strategys: LinkedMultiValueMap<String, AbstractStrategyDomain> = LinkedMultiValueMap<String, AbstractStrategyDomain>();

	@Bean
	open fun createStrategy(strategies: List<AbstractStrategyDomain>): Boolean {

		strategies.forEach{ _strategy ->

			_strategy.registerStrategy().forEach { _domain ->

				strategys.add(_domain, _strategy)
			}
		}

		return true;
	}

	fun getStrategy(domain: String) = strategys[domain]!!.first()

}