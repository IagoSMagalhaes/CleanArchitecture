package com.asset.management.controller

import com.asset.management.entities.dto.request.RequestDeleteAssetEntity
import com.asset.management.entities.dto.request.RequestPostAssetEntity
import com.asset.management.entities.dto.request.RequestPutAssetEntity
import com.asset.management.service.AssetService
import com.asset.management.service.AssetServiceImpl
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@ApiOperation(tags = ["Asset CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the Asset entity")
class AssetController(val service: AssetService) {


	@GetMapping("/v1")
	@CrossOrigin
	@ApiOperation("Find all asset's ", response = HttpStatus::class)
	fun get() = ResponseEntity.ok(service.get())


	@PostMapping("/v1")
	@ApiOperation("Save new asset", response = HttpStatus::class)
	fun post(@RequestBody body: RequestPostAssetEntity): ResponseEntity<HttpStatus> {

		service.post(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@PutMapping("/v1")
	@ApiOperation("Update data asset", response = HttpStatus::class)
	fun put(@RequestBody body: RequestPutAssetEntity): ResponseEntity<HttpStatus> {

		service.put(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("v1")

	@ApiOperation("Exclude asset by name", response = HttpStatus::class)
	fun delete(@RequestBody body: RequestDeleteAssetEntity): ResponseEntity<HttpStatus> {

		service.delete(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}



}