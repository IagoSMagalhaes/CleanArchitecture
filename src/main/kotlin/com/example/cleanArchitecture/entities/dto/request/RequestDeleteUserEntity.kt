package com.example.cleanArchitecture.entities.dto.request

class RequestDeleteUserEntity(val user: DeleteUserEntity)

class DeleteUserEntity(val id: List<Long> = emptyList(),
                       val name: List<String> = emptyList())