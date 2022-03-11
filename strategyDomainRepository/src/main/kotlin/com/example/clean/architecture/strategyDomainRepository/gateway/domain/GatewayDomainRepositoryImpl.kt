package com.example.clean.architecture.strategyDomainRepository.gateway.domain

import com.example.clean.architecture.strategyDomainRepository.service.impl.DomainUsecaseImpl
import com.example.clean.architecture.gatewayRepository.otherRepositories.domainRepository.domain.GatewayDomainRepository
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayDomainRepositoryImpl(val service: DomainUsecaseImpl) : GatewayDomainRepository {

	override fun get(domain: String, query: String?) = service.get(domain, query)

}