package com.example.clean.architecture.entities.user.dto.request

open class RequestGetUserEntity(
                     val id: Long? = null,
                     val name: String? = null,
                     val cellphone: String? = null,
                     val email: String? = null) {

    fun perId() = id != null

    fun perName() = name != null

    fun perCellphone() = cellphone != null

    fun perEmail() = email != null
}
