package com.example.clean.architecture.strategyDomainRepository.gateway.domain

import com.example.clean.architecture.strategyDomainRepository.service.impl.DomainServiceImpl
import com.example.clean.architecture.gatewayRepository.domainRepository.domain.GatewayDomainRepository
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayDomainRepositoryImpl(val service: DomainServiceImpl) : GatewayDomainRepository {

	override fun get(domain: String, query: String?) = service.get(domain, query)

}