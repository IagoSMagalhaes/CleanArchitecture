package com.example.clean.architecture.strategyDomainRepository.gateway.strategy

import com.example.clean.architecture.gatewayRepository.domainRepository.strategy.GatewayStrategyDomainRepository
import com.example.clean.architecture.strategyDomainRepository.strategy.factory.StrategyDomainFactory
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.buildGet
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayStrategyDomainRepositoryImpl(val factory: StrategyDomainFactory) : GatewayStrategyDomainRepository {

	override fun get(domain: String) = factory.get(domain).buildGet()

}


