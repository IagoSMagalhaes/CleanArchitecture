package com.example.cleanArchitecture.entities.dto.request

import com.example.cleanArchitecture.entities.domain.UserEntity

class RequestPostUserEntity(val user: PostUserEntity)

class PostUserEntity(val name: String,
                     val cellphone: String,
                     val email: String,
                     val active: Boolean? = true)

fun PostUserEntity.toEntity() = UserEntity(name = name,
                                           cellphone = cellphone,
                                           email = email,
                                           active = active)