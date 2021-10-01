package com.example.cleanArchitecture.controller.user

import com.example.cleanArchitecture.service.user.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
@ApiOperation(tags = ["User CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the User entity")
class UserImageController(val service: UserService) {

	@GetMapping("/user/v1/image/{id}")
	@ApiOperation("Get Image user")
	fun get(@PathVariable id: Long?): HttpEntity<ByteArray> {

		val image = service.getFull(id!!).image

		val headers = HttpHeaders()
		headers.contentType = MediaType.IMAGE_JPEG
		headers.contentLength = image!!.size.toLong()

		return HttpEntity(image, headers)
	}

}