package com.asset.management.service

import com.asset.management.entities.domain.AssetEntity
import com.asset.management.entities.dto.request.RequestDeleteAssetEntity
import com.asset.management.entities.dto.request.RequestPostAssetEntity
import com.asset.management.entities.dto.request.RequestPutAssetEntity


interface AssetService {

	fun get() : List<AssetEntity>

	fun post(body: RequestPostAssetEntity)

    fun put(body: RequestPutAssetEntity)

	fun delete(body: RequestDeleteAssetEntity)
}