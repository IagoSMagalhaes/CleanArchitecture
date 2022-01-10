package com.example.clean.architecture.controller.http.user

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestGetUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.usecases.service.user.UserUsecase
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RequestMapping("/user")
@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
open class UserController(val service: UserUsecase) {


	@GetMapping("/v1")
	@CrossOrigin
	@Secured("ROLE_ADMIN")
	@ApiOperation("Find all users", response = HttpStatus::class)
	fun get(): ResponseEntity<List<UserEntity>> {

		val response = service.get()

		return ResponseEntity.ok(response)
	}

	@GetMapping("/v1/by")
	@ApiOperation("Find users by", response = HttpStatus::class)
	fun getBy(@RequestHeader id: Long? = null, @RequestHeader name: String? = null, @RequestHeader cellphone: String? = null, @RequestHeader email: String? = null): ResponseEntity<List<UserEntity>> {

		val body = RequestGetUserEntity(id = id, name = name, cellphone = cellphone, email = email)

		val response = service.getBy(body)

		return ResponseEntity.ok(response)
	}

	@PutMapping("/v1")
	@ApiOperation("Update User", response = HttpStatus::class)
	fun put(@Valid  @RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus> {

		service.put(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("/v1")
	@ApiOperation("Delete User by Id", response = HttpStatus::class)
	fun delete(@RequestBody id: Long): ResponseEntity<HttpStatus> {

		service.delete(id)

		return ResponseEntity.ok(HttpStatus.OK)
	}

}