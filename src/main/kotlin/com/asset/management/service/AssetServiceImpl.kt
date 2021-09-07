package com.asset.management.service

import com.asset.management.entities.domain.AssetEntity
import com.asset.management.entities.dto.request.RequestDeleteAssetEntity
import com.asset.management.entities.dto.request.RequestPostAssetEntity
import com.asset.management.entities.dto.request.RequestPutAssetEntity
import com.asset.management.entities.dto.request.toEntity
import com.asset.management.entities.exceptions.AssetDeleteException
import com.asset.management.entities.exceptions.AssetGetException
import com.asset.management.entities.exceptions.AssetPostException
import com.asset.management.entities.exceptions.AssetPutException
import com.asset.management.repository.domain.Asset
import com.asset.management.repository.domain.toDomain
import com.asset.management.repository.domain.toEntity
import com.asset.management.repository.repository.AssetRepository
import jdk.nashorn.internal.runtime.logging.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
@Logger
class AssetServiceImpl(val repository: AssetRepository) : AssetService {

	val LOG = LoggerFactory.getLogger(AssetServiceImpl::class.java)

	override fun get() : List<AssetEntity> {

		LOG.info("START GET Asset")

		var response = emptyList<Asset>()

		runCatching {

			response = repository.findAll()

		}.onFailure {

			LOG.error("ERROR GET Asset message: {} causeMessage: {}", it.message, it.cause!!.message)

			throw AssetGetException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_GET_EXCEPTION", "user.get.exception")

		}.onSuccess {

			LOG.info("END GET Asset response: {}", response.size)

		}

		//return ResponseGetAssetEntity(response.toEntity())
		return response.toEntity()
	}

	override fun post(body: RequestPostAssetEntity) {

		LOG.info("START POST Asset body: {}", body)

		runCatching {

			val domain = body.user.toEntity().toDomain()

			repository.save(domain)

		}.onFailure {

			LOG.error("ERROR POST Asset body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw AssetPostException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_POST_EXCEPTION", "user.post.exception")

		}.onSuccess {

			LOG.info("END POST Asset")

		}
	}


	override fun put(body: RequestPutAssetEntity){

		LOG.info("START PUT Asset body: {}", body)

		runCatching {

			val domain = body.user.toEntity(1L).toDomain()

			repository.save(domain)

		}.onFailure {

			LOG.error("ERROR PUT Asset body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw AssetPutException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_PUT_EXCEPTION", "user.put.exception")

		}.onSuccess {

			LOG.info("END PUT Asset")

		}

	}

	override fun delete(body: RequestDeleteAssetEntity){

		LOG.info("START DELETE Asset body: {}", body)

		runCatching {

			//val response = repository.findByNameIn(body.user.name)

		//	repository.deleteAll(response)

		}.onFailure {

			LOG.error("ERROR DELETE Asset body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw AssetDeleteException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_DELETE_EXCEPTION", "user.delete.exception")

		}.onSuccess {

			LOG.info("END DELETE Asset")
		}

	}
}