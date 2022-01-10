package com.example.clean.architecture.usecases.service.chainOfResponsability.impl.handlers

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity


interface ChainHandlerCreateUserService {

	fun execute(body: RequestPostUserEntity)

	fun next(body: RequestPostUserEntity)

}
