package com.asset.management.entities.dto.request

import com.asset.management.entities.domain.AssetEntity

class RequestPostAssetEntity(val user: PostAssetEntity)

class PostAssetEntity(val name: String?,
                     val fullValue: Double?,
                     val manager: String?,
                     val active: Boolean? = true)

fun PostAssetEntity.toEntity() = AssetEntity(name = name,
                                           fullValue = fullValue,
                                           manager = manager,
                                           active = active)