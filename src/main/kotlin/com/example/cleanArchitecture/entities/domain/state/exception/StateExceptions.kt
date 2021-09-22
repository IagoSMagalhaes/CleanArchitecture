package com.example.cleanArchitecture.entities.domain.state.exception

import com.example.cleanArchitecture.entities.abstract.AbstractException
import org.springframework.http.HttpStatus

class StateGetException(override val httpStatusCode: HttpStatus,
                        override val codeMessage: String,
                        override val message: String,
                        override val throwable: Throwable? = null) : AbstractException()

class StatePostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "STATE_POST_EXCEPTION",
                        override val message: String = "state.post.exception",
                         override val throwable: Throwable? = null) : AbstractException()