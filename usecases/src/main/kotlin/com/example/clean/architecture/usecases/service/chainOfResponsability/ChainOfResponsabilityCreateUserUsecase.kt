package com.example.clean.architecture.usecases.service.chainOfResponsability

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity


interface ChainOfResponsabilityCreateUserUsecase {

	fun execute(body: RequestPostUserEntity)

}
