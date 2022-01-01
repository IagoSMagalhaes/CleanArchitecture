package com.example.clean.architecture.entities.user.dto.request

import com.example.clean.architecture.entities.user.domain.UserEntity
import javax.validation.constraints.NotNull

open class RequestPutUserEntity(
    @get:NotNull(message = "name is required") val id: Long,
    val name: String? = null,
    val cellphone: String? = null,
    val email: String? = null,
    val active: Boolean? = true)


fun RequestPutUserEntity.toEntity() = UserEntity(
                                            id = id,
                                            name = this.name?.let { it },
                                            email = this.email?.let { it },
                                            active = this.active?.let { it },
                                            cellphone = this.cellphone?.let { it })