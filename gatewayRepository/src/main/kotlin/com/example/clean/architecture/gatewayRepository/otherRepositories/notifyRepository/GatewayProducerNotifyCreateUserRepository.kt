package com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity


open interface GatewayProducerNotifyCreateUserRepository {

	fun produce(body: RequestPostNotifyCreateUserEntity)
}

