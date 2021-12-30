package com.example.clean.architecture.gateway

import com.example.clean.architecture.domainRepository.service.impl.DomainServiceImpl
import com.example.clean.architecture.gatewayRepository.domainRepository.GatewayDomainRepository
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayDomainRepositoryImpl(val service: DomainServiceImpl) : GatewayDomainRepository {

	override fun get(domain: String, query: String?) = service.get(domain, query)

}