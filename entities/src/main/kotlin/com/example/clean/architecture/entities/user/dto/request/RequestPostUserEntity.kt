package com.example.clean.architecture.entities.user.dto.request

import com.example.clean.architecture.entities.user.domain.UserEntity
import java.util.*

open class RequestPostUserEntity(
                     val name: String,
                     val cellphone: String,
                     val email: String,
                     val active: Boolean? = true,
                     val image: String? = null)

fun RequestPostUserEntity.toEntity() = UserEntity(name = name,
                                           cellphone = cellphone,
                                           email = email,
                                           active = active,
                                            image = image?.let { Base64.getDecoder().decode(it)})