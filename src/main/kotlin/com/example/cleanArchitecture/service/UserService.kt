package com.example.cleanArchitecture.service

import com.example.cleanArchitecture.controller.RequestPostUserEntity
import com.example.cleanArchitecture.controller.ResponseGetUserEntity


interface UserService {

	fun get() : ResponseGetUserEntity

	fun post(body: RequestPostUserEntity)

	fun put()

	fun delete()
}