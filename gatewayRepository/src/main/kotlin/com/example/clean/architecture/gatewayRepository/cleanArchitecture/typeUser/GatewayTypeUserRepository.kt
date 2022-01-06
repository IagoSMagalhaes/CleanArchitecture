package com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser

import com.example.clean.architecture.entities.cleanArchitecture.typeUser.domain.TypeUserEntity


interface GatewayTypeUserRepository {

	fun get() : List<TypeUserEntity>
}

