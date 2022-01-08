package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability.impl.handlers

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity


interface ChainCreateUserHandlerService {

	fun execute(body: RequestPostUserEntity)

	fun next(body: RequestPostUserEntity)

}
