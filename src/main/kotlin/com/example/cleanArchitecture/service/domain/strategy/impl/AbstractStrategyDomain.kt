package com.example.cleanArchitecture.service.domain.strategy.impl

import com.example.cleanArchitecture.entities.domain.enun.DomainEnum
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService


abstract class AbstractStrategyDomain {

	constructor(domain: DomainEnum, service: AbstractDomainService)

	abstract val domain: DomainEnum

	abstract val service: AbstractDomainService

	fun registerStrategy(): List<String> = domain.domains

	fun execute(domain: String, query: String?)  =
		service.get(domain, query)
}