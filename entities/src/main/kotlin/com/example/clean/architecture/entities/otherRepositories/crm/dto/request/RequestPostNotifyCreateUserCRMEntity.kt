package com.example.clean.architecture.entities.otherRepositories.crm.dto.request

open class RequestPostNotifyCreateUserCRMEntity(val name: String,
                                                val login: String,
                                                val email: String,
                                                val cellphone: String,
                                                val userAgent: String? = null,
                                                val userIp: String? = null
)