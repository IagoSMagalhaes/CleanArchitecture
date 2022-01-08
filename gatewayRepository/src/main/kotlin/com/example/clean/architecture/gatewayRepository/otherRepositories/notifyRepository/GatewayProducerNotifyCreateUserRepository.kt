package com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity


interface GatewayProducerNotifyCreateUserRepository {

	fun produce(body: RequestPostNotifyCreateUserEntity)
}

