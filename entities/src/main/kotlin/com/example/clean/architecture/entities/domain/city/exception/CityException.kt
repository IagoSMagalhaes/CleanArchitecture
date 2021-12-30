package com.example.clean.architecture.entities.domain.city.exception

import com.example.clean.architecture.entities.abstract.AbstractException
import org.springframework.http.HttpStatus

open class CityGetException(override val httpStatusCode: HttpStatus,
                        override val codeMessage: String,
                        override val message: String,
                        override val throwable: Throwable? = null) : AbstractException()

open class CityPostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "CITY_POST_EXCEPTION",
                        override val message: String = "city.post.exception",
                         override val throwable: Throwable? = null) : AbstractException()