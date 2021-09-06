package com.example.cleanArchitecture.controller

import com.example.cleanArchitecture.entities.dto.request.RequestPostTransactionalEntity
import com.example.cleanArchitecture.service.transactional.TransactionalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@Api(tags = ["Transacional CRUD"], description = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
class TransactionalController(val service: TransactionalService) {

	@PostMapping("transactional/v1")
	@ApiOperation("POST Transacional ", response = HttpStatus::class)
	fun post(@RequestBody body: RequestPostTransactionalEntity) =
		ResponseEntity.ok(service.post(body))


}