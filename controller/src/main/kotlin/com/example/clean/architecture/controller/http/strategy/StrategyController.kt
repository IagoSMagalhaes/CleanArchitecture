package com.example.clean.architecture.controller.http.strategy
import com.example.clean.architecture.controller.http.helper.getDomain
import com.example.clean.architecture.controller.http.helper.getHeaders
import com.example.clean.architecture.entities.otherRepositories.domain.dto.response.ResponseGetStrategyDomainEntity
import com.example.clean.architecture.gatewayRepository.otherRepositories.domainRepository.strategy.GatewayStrategyDomainRepository
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


@RequestMapping("/strategy")
@RestController
@ApiOperation(tags = ["Strategy"], value = "Layer responsible to recevie request to manager the Strategy")
class StrategyController(val gatewayStrategyDomain: GatewayStrategyDomainRepository, val request: HttpServletRequest) {


	@GetMapping("/v1")
	@CrossOrigin
	@ApiOperation("Find Strategies by domain ", response = HttpStatus::class)
	@ApiImplicitParams( value = [
		ApiImplicitParam(name = "domain", required = true, paramType = "header")])
	fun get(): ResponseEntity<ResponseGetStrategyDomainEntity> {

		val domain = request.getHeaders().getDomain(true)!!

		val response = gatewayStrategyDomain.get(domain)

		return ResponseEntity.ok(response)
	}

}

