package com.example.clean.architecture.entities.user.exception

import com.example.clean.architecture.entities.abstract.AbstractException
import org.springframework.http.HttpStatus


open class UserPostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                         override val codeMessage: String = "USER_POST_EXCEPTION",
                         override val message: String = "user.post.exception",
                         override val throwable: Throwable? = null) : AbstractException()

open class UserGetException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "USER_POST_EXCEPTION",
                        override val message: String = "user.post.exception",
                        override val throwable: Throwable? = null) : AbstractException()

open class UserPutException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                       override val codeMessage: String = "USER_POST_EXCEPTION",
                       override val message: String = "user.post.exception",
                       override val throwable: Throwable? = null) : AbstractException()

open class UserDeleteException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                       override val codeMessage: String = "USER_POST_EXCEPTION",
                       override val message: String = "user.post.exception",
                       override val throwable: Throwable? = null) : AbstractException()

