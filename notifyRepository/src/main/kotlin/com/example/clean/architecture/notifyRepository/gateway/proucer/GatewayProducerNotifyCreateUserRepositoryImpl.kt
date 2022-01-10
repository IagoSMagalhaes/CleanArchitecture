package com.example.clean.architecture.notifyRepository.gateway.proucer

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.producer.GatewayProducerNotifyCreateUserRepository
import com.example.clean.architecture.notifyRepository.service.producer.ProducerNotifyCreateUserUsecase
import org.springframework.stereotype.Service


@Service
open class GatewayProducerNotifyCreateUserRepositoryImpl(val service: ProducerNotifyCreateUserUsecase) :
	GatewayProducerNotifyCreateUserRepository {

	override fun produce(body: RequestPostNotifyCreateUserEntity) = service.produce(body)

	}