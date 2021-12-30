package com.example.clean.architecture.controller.user

import com.example.clean.architecture.entities.user.domain.UserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.service.user.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/user")
@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
open class UserController(val service: UserService) {


	@GetMapping("/v1")
	@CrossOrigin
	@ApiOperation("Find all users", response = HttpStatus::class)
	fun get(): ResponseEntity<List<UserEntity>> {

		val response = service.get()

		return ResponseEntity.ok(response)
	}

	@PostMapping("/v1")
	@ApiOperation("Save User", response = HttpStatus::class)
	fun post(@RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus> {

		service.post(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}


	@PutMapping("/v1")
	@ApiOperation("Update User", response = HttpStatus::class)
	fun put(@RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus> {

		service.put(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("/v1")
	@ApiOperation("Update User", response = HttpStatus::class)
	fun delete(@RequestBody id: Long): ResponseEntity<HttpStatus> {

		service.delete(id)

		return ResponseEntity.ok(HttpStatus.OK)
	}

}