package com.example.clean.architecture.entities.cleanArchitecture.user.dto.request

open class RequestDeleteUserEntity(val user: DeleteUserEntity)

open class DeleteUserEntity(val id: List<Long> = emptyList(),
                       val name: List<String> = emptyList())