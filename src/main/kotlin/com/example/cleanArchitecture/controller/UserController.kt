package com.example.cleanArchitecture.controller

//import io.swagger.annotations.ApiOperation
import com.example.cleanArchitecture.service.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
//@ApiOper
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
	fun put(): ResponseEntity<HttpStatus> {
		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("user/v1")
	fun delete(): ResponseEntity<HttpStatus> {
		return ResponseEntity.ok(HttpStatus.OK)
	}
}