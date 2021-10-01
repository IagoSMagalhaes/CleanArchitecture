package com.example.cleanArchitecture.controller.config

import com.example.cleanArchitecture.entities.abstract.ApiError
import com.example.cleanArchitecture.entities.exception.AuthUnauthorizedException
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class CleanArchitectureHandler(val messageSource: MessageSource) {

	val LOG = LoggerFactory.getLogger(CleanArchitectureHandler::class.java)



		@ResponseStatus(HttpStatus.UNAUTHORIZED)
		@ExceptionHandler(value = [AuthUnauthorizedException::class])
		fun handle(e: AuthUnauthorizedException) : ApiError {
			LOG.error("ERROR AUTHENTICATE " + e.message)
			return ApiError(e.httpStatusCode.value(), e.codeMessage, e.message)
		}
}