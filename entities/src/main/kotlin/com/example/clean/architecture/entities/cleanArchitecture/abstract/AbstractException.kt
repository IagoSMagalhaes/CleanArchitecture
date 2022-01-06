package com.example.clean.architecture.entities.cleanArchitecture.abstract

import org.springframework.http.HttpStatus

abstract open class AbstractException : RuntimeException() {

    abstract val httpStatusCode: HttpStatus
    abstract val throwable: Throwable?
    abstract val codeMessage: String
    abstract override val message: String

}

open class ApiError(val httpStatusCode: Int,
               val codeMessage: String,
               val message: String)