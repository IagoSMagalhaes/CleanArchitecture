package com.example.clean.architecture.controller.domain
import com.example.clean.architecture.controller.helper.getDomain
import com.example.clean.architecture.controller.helper.getHeaders
import com.example.clean.architecture.controller.helper.getQuery
import com.example.clean.architecture.entities.domain.domain.DomainEntity
import com.example.clean.architecture.gatewayRepository.domainRepository.GatewayDomainRepository
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RequestMapping("/domain")
@RestController
@ApiOperation(tags = ["Domain CRUD"], value = "Layer responsible to recevie request to manager Create/Read/Update/Delete the Domain entity")
class DomainController(val service: GatewayDomainRepository, val request: HttpServletRequest) {


	@GetMapping("/v1")
	@CrossOrigin
	@ApiOperation("Find all domain's ", response = HttpStatus::class)
	@ApiImplicitParams( value = [
		ApiImplicitParam(name = "domain", required = true, value = "Country State City", paramType = "header"),
		ApiImplicitParam(name = "query", required = false, paramType = "header")
	])
	fun get(): ResponseEntity<List<DomainEntity>> {

		val domain = request.getHeaders().getDomain(true)!!

		val query = request.getHeaders().getQuery(false)

		val response = service.get(domain, query)

		return ResponseEntity.ok(response)
	}

}