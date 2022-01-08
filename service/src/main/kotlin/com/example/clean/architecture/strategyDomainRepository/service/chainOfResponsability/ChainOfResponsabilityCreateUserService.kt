package com.example.clean.architecture.strategyDomainRepository.service.chainOfResponsability

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity


interface ChainOfResponsabilityCreateUserService {

	fun execute(body: RequestPostUserEntity)

}
