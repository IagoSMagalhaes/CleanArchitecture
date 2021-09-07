package com.asset.management.entities.dto.request

import com.asset.management.entities.domain.AssetEntity

class RequestPutAssetEntity(val user: PutAssetEntity)

class PutAssetEntity(val name: String? = null,
                     val fullValue: Double? = null,
                     val manager: String? = null,
                     val active: Boolean? = true)

fun PutAssetEntity.toEntity(id: Long) = AssetEntity(
                                            id = id,
                                            name = this.name?.let { it },
                                            fullValue = this.fullValue?.let { it })