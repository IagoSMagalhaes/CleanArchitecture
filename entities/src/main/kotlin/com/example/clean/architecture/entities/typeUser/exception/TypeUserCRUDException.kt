package com.example.clean.architecture.entities.typeUser.exception

import com.example.clean.architecture.entities.abstract.AbstractException
import org.springframework.http.HttpStatus


open class TypeUserGetException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "TYPE_USER_POST_EXCEPTION",
                        override val message: String = "type.user.post.exception",
                        override val throwable: Throwable? = null) : AbstractException()

open class TypeUserPostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                       override val codeMessage: String = "TYPE_USER_POST_EXCEPTION",
                       override val message: String = "type.user.post.exception",
                       override val throwable: Throwable? = null) : AbstractException()

