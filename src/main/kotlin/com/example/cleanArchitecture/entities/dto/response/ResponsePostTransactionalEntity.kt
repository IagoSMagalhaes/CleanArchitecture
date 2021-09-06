package com.example.cleanArchitecture.entities.dto.response

class ResponsePostTransactionalEntity(
    val account: PostTransactionalAccountEntity,
    val validations: PostTransactionalValidationEntity)


class PostTransactionalAccountEntity(
    val active: Boolean,
    var availableLimit: Long)


class PostTransactionalValidationEntity(
    val validations: List<String>)