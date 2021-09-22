package com.asset.management.entities.repositoryDomain.state.domain

import java.time.LocalDateTime

class StateEntity(val id: Long? = null,
                  val fullName: String?,
                  val active: Boolean?,
                  val dateCreate: LocalDateTime? = LocalDateTime.now(),
                  val dateUpdate: LocalDateTime? = null,
                  val dateExclude: LocalDateTime? = null) {

}
