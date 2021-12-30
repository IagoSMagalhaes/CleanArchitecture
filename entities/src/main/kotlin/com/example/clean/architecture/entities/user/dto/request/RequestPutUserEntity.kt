package com.example.clean.architecture.entities.user.dto.request

import com.example.clean.architecture.entities.user.domain.UserEntity

open class RequestPutUserEntity(val user: PutUserEntity)

open class PutUserEntity(val name: String? = null,
                     val cellphone: String? = null,
                     val email: String? = null,
                     val active: Boolean? = true)

fun PutUserEntity.toEntity(id: Long) = UserEntity(
                                            id = id,
                                            name = this.name?.let { it },
                                            cellphone = this.cellphone?.let { it })