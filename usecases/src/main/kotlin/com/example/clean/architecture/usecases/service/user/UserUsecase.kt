package com.example.clean.architecture.usecases.service.user

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestGetUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity


interface UserUsecase {

	fun get() : List<UserEntity>

	fun getBy(body: RequestGetUserEntity) : List<UserEntity>

	fun post(body: RequestPostUserEntity)

	//fun createUser(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

	fun delete(id: Long)

    fun getFull(id: Long) : UserEntity
}