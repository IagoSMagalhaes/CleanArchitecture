package com.example.clean.architecture.notifyRepository.client

import com.example.clean.architecture.entities.otherRepositories.crm.dto.request.RequestPostNotifyCreateUserCRMEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


//@FeignClient(value = "crmClient", url = "\${ur.api.crm}")
@Service
open interface CRMClient{

    @PostMapping("/user/v1")
    fun notifyCRM(@RequestBody body: RequestPostNotifyCreateUserCRMEntity)

}