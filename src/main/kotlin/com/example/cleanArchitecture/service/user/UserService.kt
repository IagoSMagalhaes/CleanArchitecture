package com.example.cleanArchitecture.service.user

import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.entities.dto.response.ResponseGetUserEntity


interface UserService {

	fun get() : ResponseGetUserEntity

	fun post(body: RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

    fun block(document: String)

	fun delete(body: RequestDeleteUserEntity)
}