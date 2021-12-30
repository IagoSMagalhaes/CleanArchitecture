package com.example.clean.architecture.entities.domain.city.domain

import java.time.LocalDateTime

open class CityEntity(val id: Long? = null,
                 val fullName: String?,
                 val active: Boolean?,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
