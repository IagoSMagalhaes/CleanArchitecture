package com.example.clean.architecture.usecases.service.typeUser

import com.example.clean.architecture.entities.cleanArchitecture.typeUser.domain.TypeUserEntity


interface TypeUserUsecase {

	fun get() : List<TypeUserEntity>

	//fun post() : List<TypeUserEntity>
}