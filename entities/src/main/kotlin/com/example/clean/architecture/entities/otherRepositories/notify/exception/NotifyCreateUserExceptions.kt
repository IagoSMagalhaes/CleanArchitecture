package com.example.clean.architecture.entities.otherRepositories.notify.exception

import com.example.clean.architecture.entities.cleanArchitecture.abstract.AbstractException
import org.springframework.http.HttpStatus


open class PostNotifyCreateUserException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "POST_NOTIFY_CREATE_USER_EXCEPTION",
                        override val message: String = "post.notify.create.user.exception",
                         override val throwable: Throwable? = null) : AbstractException()