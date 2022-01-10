package com.example.clean.architecture.gatewayRepository.otherRepositories.notifyRepository.crm

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity


interface GatewayNotifyCreateUserCRMRepository {

	fun notifyCRM(body: RequestPostNotifyCreateUserCRMEntity)
}

