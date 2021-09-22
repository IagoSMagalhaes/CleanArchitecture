package com.example.cleanArchitecture.service.city

import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.entities.user.domain.UserEntity
import com.example.cleanArchitecture.entities.user.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.entities.user.dto.response.ResponseGetUserEntity


interface CityService {

	fun get() : ResponseGetUserEntity

	fun post(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

	fun delete(body: RequestDeleteUserEntity)

    fun getFull(id: Long) : UserEntity
}