package com.asset.management.entities.repositoryDomain.city.domain

import java.time.LocalDateTime

class CityEntity(val id: Long? = null,
                 val fullName: String?,
                 val active: Boolean?,
                 val dateCreate: LocalDateTime? = LocalDateTime.now(),
                 val dateUpdate: LocalDateTime? = null,
                 val dateExclude: LocalDateTime? = null) {

}
