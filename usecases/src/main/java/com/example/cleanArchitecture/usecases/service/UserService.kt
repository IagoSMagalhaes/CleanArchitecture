package com.example.cleanArchitecture.usecases.service

import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.entities.dto.response.ResponseGetUserEntity


interface UserService {

	fun get() : ResponseGetUserEntity

	fun post(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

	fun delete(body: RequestDeleteUserEntity)
}