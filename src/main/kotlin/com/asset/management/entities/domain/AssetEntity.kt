package com.asset.management.entities.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime

class AssetEntity(val id: Long? = null,
                  val name: String?,
               //   val type: AssetType? = null,
               //   val operationType: operationType? = null,
                  @JsonIgnore
                  val fullValue: Double? = null,
                  @JsonIgnore
                  val manager: String? = null,
                  @JsonIgnore
                  val active: Boolean? = null,
                  @JsonIgnore
                  val dateCreate: LocalDateTime? = LocalDateTime.now(),
                  @JsonIgnore
                  val dateUpdate: LocalDateTime? = null,
                  @JsonIgnore
                  val dateExclude: LocalDateTime? = null) {

}
