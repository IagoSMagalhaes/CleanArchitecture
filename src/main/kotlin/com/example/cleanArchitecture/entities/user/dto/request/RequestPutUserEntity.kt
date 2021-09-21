package com.example.cleanArchitecture.entities.dto.request

import com.example.cleanArchitecture.entities.user.domain.UserEntity

class RequestPutUserEntity(val user: PutUserEntity)

class PutUserEntity(val name: String? = null,
                     val cellphone: String? = null,
                     val email: String? = null,
                     val active: Boolean? = true)

fun PutUserEntity.toEntity(id: Long) = UserEntity(
                                            id = id,
                                            name = this.name?.let { it },
                                            cellphone = this.cellphone?.let { it })