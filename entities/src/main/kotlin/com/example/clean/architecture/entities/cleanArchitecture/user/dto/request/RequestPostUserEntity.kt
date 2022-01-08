package com.example.clean.architecture.entities.cleanArchitecture.user.dto.request

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity
import com.example.clean.architecture.entities.otherRepositories.notify.dto.request.RequestPostNotifyCreateUserEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.validation.constraints.NotNull

@JsonIgnoreProperties(ignoreUnknown = true)
open class RequestPostUserEntity(
    @get:NotNull(message = "name is required") val name: String,
    @get:NotNull(message = "cellphone is required") val cellphone: String,
    @get:NotNull(message = "email is required") val email: String,
    val active: Boolean? = true,
    val image: String? = null)

fun RequestPostUserEntity.toEntity() = UserEntity(name = name,
                                           cellphone = cellphone,
                                           email = email,
                                           active = active,
                                            image = image?.let { Base64.getDecoder().decode(it)})


fun RequestPostUserEntity.toRequestPostLdapUserEntity() = RequestPostLdapUserEntity( name, "001122")

fun RequestPostUserEntity.toRequestPostNotifyCreateUserEntity() = RequestPostNotifyCreateUserEntity( name, email, cellphone)