package com.example.cleanArchitecture.controller.domain

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity
import com.example.cleanArchitecture.entities.helper.getDomain
import com.example.cleanArchitecture.entities.helper.getHeaders
import com.example.cleanArchitecture.service.domain.service.impl.DomainServiceImpl
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@RestController
@ApiOperation(tags = ["Domain CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the Domain entity")
class DomainController(val service: DomainServiceImpl,
					   val request: HttpServletRequest
) {


	@GetMapping("/domain/v1")
	@CrossOrigin
	@ApiOperation("Find all domain's ", response = HttpStatus::class)
	//@ApiImplicitParam(value = "brand", name = "brand")
	fun get(): ResponseEntity<List<DomainEntity>> {

		val domain = request.getHeaders().getDomain(true)!!

		val response = service.get(domain, "")

		return ResponseEntity.ok(response)
	}

}