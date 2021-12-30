package com.example.clean.architecture.gatewayRepository.domainRepository

import com.example.clean.architecture.entities.domain.domain.DomainEntity


interface GatewayDomainRepository {

	fun get(domain: String, query: String?) : List<DomainEntity>
}

