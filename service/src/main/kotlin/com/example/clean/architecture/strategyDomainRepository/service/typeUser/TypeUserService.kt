package com.example.clean.architecture.strategyDomainRepository.service.typeUser

import com.example.clean.architecture.entities.typeUser.domain.TypeUserEntity


interface TypeUserService {

	fun get() : List<TypeUserEntity>

	//fun post() : List<TypeUserEntity>
}