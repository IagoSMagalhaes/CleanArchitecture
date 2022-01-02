package com.example.clean.architecture.entities.typeUser.domain

import java.time.LocalDateTime

open class TypeUserEntity(val id: Long? = null,
                          val name: String?,
                          val sg: String?,
                          val permission: List<String>? = emptyList(),
                          val active: Boolean? = null,
                          val dateCreate: LocalDateTime? = LocalDateTime.now(),
                          val dateUpdate: LocalDateTime? = null,
                          val dateExclude: LocalDateTime? = null) {

}
