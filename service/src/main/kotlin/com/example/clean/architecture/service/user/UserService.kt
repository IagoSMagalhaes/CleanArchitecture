package com.example.clean.architecture.service.user

import com.example.clean.architecture.entities.user.domain.UserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPutUserEntity


interface UserService {

	fun get() : List<UserEntity>

	fun post(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

	fun delete(id: Long)

    fun getFull(id: Long) : UserEntity
}