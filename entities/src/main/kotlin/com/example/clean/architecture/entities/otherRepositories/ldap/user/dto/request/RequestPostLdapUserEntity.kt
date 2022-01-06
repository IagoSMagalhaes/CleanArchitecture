package com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request

import com.example.clean.architecture.entities.otherRepositories.ldap.user.domain.LdapUserEntity

open class RequestPostLdapUserEntity(val userName: String, val password: String){

    fun toEntity() = LdapUserEntity(null, userName, password)
}