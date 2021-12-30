package com.example.clean.architecture.domainRepository.strategy.impl

import com.example.clean.architecture.entities.domain.enun.DomainEnum
import com.example.clean.architecture.domainRepository.service.AbstractDomainService


abstract open class AbstractStrategyDomain {

	constructor(domain: DomainEnum, service: AbstractDomainService)

	abstract val domain: DomainEnum

	abstract val service: AbstractDomainService

	fun registerStrategy(): List<String> = domain.domains

	fun execute(domain: String, query: String?)  =
		service.get(domain, query)
}