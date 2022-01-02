package com.example.clean.architecture.strategyDomainRepository.gateway

import com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser.GatewayTypeUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.typeUser.TypeUserService
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayTypeUserRepositoryImpl(val service: TypeUserService) : GatewayTypeUserRepository {

	override fun get() = service.get()

}


