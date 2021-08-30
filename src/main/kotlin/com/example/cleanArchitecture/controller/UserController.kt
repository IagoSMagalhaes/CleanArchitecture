package com.example.cleanArchitecture.controller

//import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
//@ApiOper
//@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
class UserController() {

	@GetMapping("user/v1")
	fun get(): ResponseEntity<HttpStatus> {
		return ResponseEntity.ok(HttpStatus.OK)
	}

	@PostMapping("user/v1")
	fun post(): ResponseEntity<HttpStatus> {
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