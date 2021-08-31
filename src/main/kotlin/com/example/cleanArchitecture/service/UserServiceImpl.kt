package com.example.cleanArchitecture.service

import com.example.cleanArchitecture.controller.RequestPostUserEntity
import com.example.cleanArchitecture.controller.ResponseGetUserEntity
import com.example.cleanArchitecture.repository.domain.User
import com.example.cleanArchitecture.repository.domain.toEntity
import com.example.cleanArchitecture.repository.repository.UserRepository
import jdk.nashorn.internal.runtime.logging.Logger
import org.springframework.stereotype.Service


@Service
@Logger
class UserServiceImpl(val repository: UserRepository) : UserService {

	override fun get() : ResponseGetUserEntity {

		var response = emptyList<User>()

		runCatching {

			response = repository.findAll()

		}.onFailure {

			throw it

		}.onSuccess {

		}

		return ResponseGetUserEntity(response.toEntity())
	}

	override fun post(body: RequestPostUserEntity) {
		runCatching {

			val entity = User(names = body.name, ids = null)

			repository.save(entity)

		}.onFailure {

			throw it

		}.onSuccess {

		}
	}


	override fun put(){

	}

	override fun delete(){
	}
}