package com.example.clean.architecture.usecases.gateway

import com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser.GatewayTypeUserRepository
import com.example.clean.architecture.usecases.service.typeUser.TypeUserUsecase
import org.springframework.context.annotation.Configuration


@Configuration
open class GatewayTypeUserRepositoryImpl(val service: TypeUserUsecase) : GatewayTypeUserRepository {

	override fun get() = service.get()

}


