package com.example.cleanArchitecture.entities.user.dto.request

import com.example.cleanArchitecture.entities.user.domain.UserEntity
import java.util.*

class RequestPostUserEntity(
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