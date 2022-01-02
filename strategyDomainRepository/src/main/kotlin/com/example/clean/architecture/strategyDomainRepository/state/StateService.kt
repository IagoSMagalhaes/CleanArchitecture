package com.example.clean.architecture.domainRepository.state

import com.example.clean.architecture.entities.user.domain.UserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestDeleteUserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.entities.user.dto.response.ResponseGetUserEntity


interface StateService {

	fun get() : ResponseGetUserEntity

	fun post(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

	fun delete(body: RequestDeleteUserEntity)

    fun getFull(id: Long) : UserEntity
}