package com.example.cleanArchitecture.entities.domain

import java.time.LocalDateTime

class UserEntity(val id: Long? = null,
                 val name: String?,
                 val cellphone: String?,
                 val email: String?,
                 val active: Boolean?,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
