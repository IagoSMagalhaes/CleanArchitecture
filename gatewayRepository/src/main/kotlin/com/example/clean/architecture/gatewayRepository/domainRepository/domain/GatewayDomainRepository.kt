package com.example.clean.architecture.gatewayRepository.domainRepository.domain

import com.example.clean.architecture.entities.domain.domain.DomainEntity


interface GatewayDomainRepository {

	fun get(domain: String, query: String?) : List<DomainEntity>
}

