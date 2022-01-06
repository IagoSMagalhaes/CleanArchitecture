package com.example.clean.architecture.entities.otherRepositories.domain.state.exception

import com.example.clean.architecture.entities.cleanArchitecture.abstract.AbstractException
import org.springframework.http.HttpStatus

open class StateGetException(override val httpStatusCode: HttpStatus,
                        override val codeMessage: String,
                        override val message: String,
                        override val throwable: Throwable? = null) : AbstractException()

open class StatePostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "STATE_POST_EXCEPTION",
                        override val message: String = "state.post.exception",
                         override val throwable: Throwable? = null) : AbstractException()