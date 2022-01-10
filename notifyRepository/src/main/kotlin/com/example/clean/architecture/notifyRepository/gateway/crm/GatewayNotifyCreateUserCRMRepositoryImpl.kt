package com.example.clean.architecture.notifyRepository.gateway.crm

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.crm.GatewayNotifyCreateUserCRMRepository
import com.example.clean.architecture.notifyRepository.service.crm.NotifyCreateUserCRMUsecase
import org.springframework.stereotype.Service


@Service
open class GatewayNotifyCreateUserCRMRepositoryImpl(val usecase: NotifyCreateUserCRMUsecase) :
	GatewayNotifyCreateUserCRMRepository {

	override fun notifyCRM(body: RequestPostNotifyCreateUserCRMEntity) = usecase.notifyCRM(body)

}