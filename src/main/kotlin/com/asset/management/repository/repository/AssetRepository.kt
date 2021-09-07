package com.asset.management.repository.repository

import com.asset.management.repository.domain.Asset
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AssetRepository : JpaRepository<Asset, Long> {

    fun findByAssetNameIn(name: List<String>) : List<Asset>
}

