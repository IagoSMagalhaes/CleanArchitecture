package com.example.clean.architecture.strategyDomainRepository.strategy.impl

import com.example.clean.architecture.entities.otherRepositories.domain.dto.response.ResponseGetStrategyDomainEntity
import com.example.clean.architecture.entities.otherRepositories.domain.enun.DomainEnum
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService


abstract open class AbstractStrategyDomain {

	constructor(domain: DomainEnum, service: AbstractDomainService)

	abstract val domain: DomainEnum

	abstract val service: AbstractDomainService

	fun registerStrategy(): List<String> = domain.domains

	fun get(domain: String, query: String?)  = service.get(domain, query)


}



fun AbstractStrategyDomain.buildGet() = ResponseGetStrategyDomainEntity(domain.name, service.javaClass.toString())