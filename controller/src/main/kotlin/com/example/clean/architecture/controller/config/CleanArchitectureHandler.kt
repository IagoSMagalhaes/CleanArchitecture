package com.example.clean.architecture.controller.config

import com.example.clean.architecture.entities.abstract.ApiError
import com.example.clean.architecture.entities.auth.exception.AuthUnauthorizedException
import org.slf4j.LoggerFactory
//import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
open class CleanArchitectureHandler(val messageSource: MessageSource) {

	 val LOG = LoggerFactory.getLogger(CleanArchitectureHandler::class.java)

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = [AuthUnauthorizedException::class])
	fun handle(e: AuthUnauthorizedException) : ApiError {
//		// LOG.error("ERROR AUTHENTICATE " + e.message)
		return ApiError(e.httpStatusCode.value(), e.codeMessage, e.message)
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = [HttpMessageNotReadableException::class])
	fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException) : ApiError {
		 LOG.info("ERROR AUTHENTICATE " + e.message)
		e.message
		return ApiError(400, e.message!!, e.message!!)
	}



}