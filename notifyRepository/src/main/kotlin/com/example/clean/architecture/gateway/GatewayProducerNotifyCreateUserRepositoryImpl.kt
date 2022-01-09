package com.example.clean.architecture.gateway

import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.GatewayProducerNotifyCreateUserRepository
import com.example.clean.architecture.service.ProducerNotifyCreateUserService
import org.springframework.stereotype.Service


@Service
open class GatewayProducerNotifyCreateUserRepositoryImpl(val service: ProducerNotifyCreateUserService) : GatewayProducerNotifyCreateUserRepository {

	override fun produce(body: RequestPostNotifyCreateUserEntity) = service.produce(body)

	}