package com.asset.management.entities.dto.request

class RequestDeleteAssetEntity(val asset: DeleteAssetEntity)

class DeleteAssetEntity(val id: List<Long> = emptyList(),
                       val name: List<String> = emptyList())