package com.example.clean.architecture.entities.user.domain

import java.time.LocalDateTime

open class UserEntity(val id: Long? = null,
                 val name: String?,
                 val cellphone: String? = null,
                 val email: String? = null,
                 val active: Boolean? = null,
                 val image: ByteArray? = null,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
