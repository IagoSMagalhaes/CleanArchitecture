package com.example.clean.architecture.controller.http.ladingPage

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.usecases.service.chainOfResponsability.impl.ChainOfResponsabilityCreateUserUsecaseImpl
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RequestMapping("/lading/page")
@RestController
@ApiOperation(tags = ["Lading Page"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
open class LadingPageController(val chainOfResponsabilityCreateUser: ChainOfResponsabilityCreateUserUsecaseImpl) {


	@PostMapping("/v1")
	@ApiOperation("Save User", response = HttpStatus::class)
	fun post(@Valid @RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus> {

		chainOfResponsabilityCreateUser.execute(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

}