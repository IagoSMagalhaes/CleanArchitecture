package com.example.cleanArchitecture.controller

import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.service.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
class UserController(val service: UserService) {

	@GetMapping("user/v1")
	fun get() = ResponseEntity.ok(service.get())


	@PostMapping("user/v1")
	fun post(@RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus> {

		service.post(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@PutMapping("user/v1")
	fun put(@RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus> {

		service.put(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("user/v1")
	fun delete(@RequestBody body: RequestDeleteUserEntity): ResponseEntity<HttpStatus> {

		service.delete(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}
}