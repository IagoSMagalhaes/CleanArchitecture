package com.example.clean.architecture.gatewayRepository.otherRepositories.domainRepository.domain

import com.example.clean.architecture.entities.otherRepositories.domain.domain.DomainEntity


interface GatewayDomainRepository {

	fun get(domain: String, query: String?) : List<DomainEntity>
}

