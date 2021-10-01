package com.example.cleanArchitecture.service.domain.strategy.factory

import com.example.cleanArchitecture.service.domain.strategy.impl.AbstractStrategyDomain
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.LinkedMultiValueMap


@Configuration
class StrategyDomainFactory() {

	var strategys: LinkedMultiValueMap<String, AbstractStrategyDomain> = LinkedMultiValueMap<String, AbstractStrategyDomain>();

	@Bean
	fun createStrategy(strategies: List<AbstractStrategyDomain>): Boolean {

		strategies.forEach{ _strategy ->
			_strategy.registerStrategy().forEach { _domain ->
				strategys.add(_domain, _strategy)
			}
		}

		return true;
	}

	fun getStrategy(domain: String) =
		strategys[domain]!!.first().service

}