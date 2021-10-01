package com.example.cleanArchitecture.entities.abstract

import org.springframework.http.HttpStatus

abstract class AbstractException : RuntimeException() {

    abstract val httpStatusCode: HttpStatus
    abstract val throwable: Throwable?
    abstract val codeMessage: String
    abstract override val message: String

}

class ApiError(val httpStatusCode: Int,
               val codeMessage: String,
               val message: String)