package com.example.cleanArchitecture.entities.exception

import com.example.cleanArchitecture.entities.abstract.AbstractException
import org.springframework.http.HttpStatus

class AuthUnauthorizedException(override val httpStatusCode: HttpStatus = HttpStatus.UNAUTHORIZED,
                        override val codeMessage: String = "ERROR_UNAUTHORIZED",
                                //TODO - ARRUMAR MENSAGEM
                        override val message: String = "Falha na autenticação",
                        override val throwable: Throwable? = null) : AbstractException()