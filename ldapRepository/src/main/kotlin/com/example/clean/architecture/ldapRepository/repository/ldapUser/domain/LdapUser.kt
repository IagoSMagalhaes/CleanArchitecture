package com.example.clean.architecture.ldapRepository.repository.ldapUser.domain

import com.example.clean.architecture.entities.otherRepositories.ldap.user.domain.LdapUserEntity
import org.springframework.ldap.odm.annotations.Attribute
import org.springframework.ldap.odm.annotations.Entry
import org.springframework.ldap.odm.annotations.Id

@Entry(
	base = "ou=users",
	objectClasses = ["person", "inetOrgPerson", "top"]
)
open class LdapUser (

	@Id
	open var id: Long? = null,

	@Attribute(name = "cn")
	open val name: String? = null,

	@Attribute(name = "cn")
	open val password: String? = null
)


fun List<LdapUser>.toEntity() = map { it.toEntity() }

fun LdapUser.toEntity() = LdapUserEntity(id = id,
										userName = name,
										password = password)

fun List<LdapUserEntity>.toDomain() = map { it.toDomain() }

fun LdapUserEntity.toDomain() = LdapUser(id = id,
										name = userName,
										password = password)


