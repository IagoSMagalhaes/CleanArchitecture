package com.example.cleanArchitecture.entities.exceptions

import org.springframework.http.HttpStatus
import java.lang.Exception

class UserGetException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserPostException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserPutException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserDeleteException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()

