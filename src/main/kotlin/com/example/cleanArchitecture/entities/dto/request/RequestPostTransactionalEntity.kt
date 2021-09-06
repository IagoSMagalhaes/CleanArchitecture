package com.example.cleanArchitecture.entities.dto.request

class RequestPostTransactionalEntity(
    val transactional: PostTransactionalTransacionalEntity,
    val account: PostTransactionalAccountEntity
    )


class PostTransactionalAccountEntity(
    val account: String,
    val status: String,
    val limit: Long)

class PostTransactionalTransacionalEntity(
    val merchant: String,
    val amount: Long,
    val dhTransactional: String)