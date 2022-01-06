package com.example.clean.architecture.gatewayRepository.otherRepositories.domainRepository.strategy

import com.example.clean.architecture.entities.otherRepositories.domain.dto.response.ResponseGetStrategyDomainEntity


interface GatewayStrategyDomainRepository {

	fun get(domain: String) : ResponseGetStrategyDomainEntity
}

