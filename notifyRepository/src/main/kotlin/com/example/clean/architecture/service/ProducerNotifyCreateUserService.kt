package com.example.clean.architecture.service

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity


interface ProducerNotifyCreateUserService {

	fun produce(body: RequestPostNotifyCreateUserEntity)
}