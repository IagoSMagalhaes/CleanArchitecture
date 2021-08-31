package com.example.cleanArchitecture.entities.domain

import java.time.LocalDateTime

class UserEntity(val id: Long? = null,
                 val name: String?,
                 val cellphone: String? = null,
                 val email: String? = null,
                 val active: Boolean? = null,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
