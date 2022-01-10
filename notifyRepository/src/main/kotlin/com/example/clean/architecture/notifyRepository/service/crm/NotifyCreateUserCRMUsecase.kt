package com.example.clean.architecture.notifyRepository.service.crm

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity


interface NotifyCreateUserCRMUsecase {

	fun notifyCRM(body: RequestPostNotifyCreateUserCRMEntity)
}