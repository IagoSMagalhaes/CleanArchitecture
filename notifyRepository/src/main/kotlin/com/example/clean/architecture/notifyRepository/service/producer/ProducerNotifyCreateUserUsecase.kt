package com.example.clean.architecture.notifyRepository.service.producer

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity


interface ProducerNotifyCreateUserUsecase {

	fun produce(body: RequestPostNotifyCreateUserEntity)
}