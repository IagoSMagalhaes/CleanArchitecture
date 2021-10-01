package com.example.cleanArchitecture.controller.user

import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.entities.helper.getHeaders
import com.example.cleanArchitecture.entities.user.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.service.auth.AuthService
import com.example.cleanArchitecture.service.user.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import javax.servlet.http.HttpServletRequest


@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
class UserController(val service: UserService,
					 val authService: AuthService,
					 val request: HttpServletRequest
) {

	@GetMapping("user/v1")
	@ApiOperation("Find all user's ", response = HttpStatus::class)
	fun get() = ResponseEntity.ok(service.get())


	@PostMapping("user/v1")
	@ApiOperation("Save new user", response = HttpStatus::class)
	fun post(@RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus> {

		val authorization = request.getHeaders().getAuthorization(true)

		authorization?.let {
			authService.validate("", it)
		}

		service.post(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@PutMapping("user/v1")
	@ApiOperation("Update data user", response = HttpStatus::class)
	fun put(@RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus> {

		service.put(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}

	@PutMapping("user/v1/block")
	@ApiOperation("Block user by Document", response = HttpStatus::class)
	fun block(@RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus> {
		return ResponseEntity.ok(HttpStatus.OK)
	}

	@DeleteMapping("user/v1")
	@ApiOperation("Exclude user by name", response = HttpStatus::class)
	fun delete(@RequestBody body: RequestDeleteUserEntity): ResponseEntity<HttpStatus> {

		service.delete(body)

		return ResponseEntity.ok(HttpStatus.OK)
	}



}




fun Map<String, List<String>>.getAuthorization(required: Boolean) : String? {

	return when {
		this.containsKey("Authorization") -> {
			return this.getValue("Authorization")[0]
		}
		required -> {
			throw IllegalArgumentException("Authorization obrigatório")
		}
		else -> null
	}

}