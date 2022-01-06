package com.example.clean.architecture.controller.http.user

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestGetUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.strategyDomainRepository.service.user.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid


@RequestMapping("/user")
@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
open class UserController(val service: UserService, val request: HttpServletRequest) {


	@GetMapping("/v1")
	@CrossOrigin
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


	@PostMapping("/v1")
	@ApiOperation("Save User", response = HttpStatus::class)
	fun post(@Valid @RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus> {

		service.post(body)

		return ResponseEntity.ok(HttpStatus.OK)
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