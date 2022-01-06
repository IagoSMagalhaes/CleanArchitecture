package com.example.clean.architecture.entities.cleanArchitecture.auth.exception

import com.example.clean.architecture.entities.cleanArchitecture.abstract.AbstractException
import org.springframework.http.HttpStatus

open class AuthUnauthorizedException(override val httpStatusCode: HttpStatus = HttpStatus.UNAUTHORIZED,
                        override val codeMessage: String = "ERROR_UNAUTHORIZED",
                                //TODO - ARRUMAR MENSAGEM
                        override val message: String = "Falha na autenticação",
                        override val throwable: Throwable? = null) : AbstractException()