package com.example.clean.architecture.entities.otherRepositories.ldap.user.exception

import com.example.clean.architecture.entities.cleanArchitecture.abstract.AbstractException
import org.springframework.http.HttpStatus



open class LdapUserPostException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                        override val codeMessage: String = "LDAP_USER_POST_EXCEPTION",
                        override val message: String = "ldap.user.post.exception",
                         override val throwable: Throwable? = null) : AbstractException()

open class LdapUserGetException(override val httpStatusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                                 override val codeMessage: String = "LDAP_USER_GET_EXCEPTION",
                                 override val message: String = "ldap.user.get.exception",
                                 override val throwable: Throwable? = null) : AbstractException()