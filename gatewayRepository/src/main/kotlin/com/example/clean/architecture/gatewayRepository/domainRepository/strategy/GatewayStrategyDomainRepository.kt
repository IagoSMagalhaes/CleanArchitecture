package com.example.clean.architecture.gatewayRepository.domainRepository.strategy

import com.example.clean.architecture.entities.domain.dto.response.ResponseGetStrategyDomainEntity


interface GatewayStrategyDomainRepository {

	fun get(domain: String) : ResponseGetStrategyDomainEntity
}

