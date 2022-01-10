package com.example.clean.architecture.entities.cleanArchitecture.user.domain

import com.example.clean.architecture.entities.cleanArchitecture.typeUser.domain.TypeUserEntity
import java.time.LocalDateTime

open class UserEntity(val id: Long? = null,
                 val name: String?,
                 val login: String? = null,
                 val password: String? = null,
                 val cellphone: String? = null,
                 val email: String? = null,
                 val typeUser: TypeUserEntity? = null,
                 val active: Boolean? = null,
                 val image: ByteArray? = null,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
