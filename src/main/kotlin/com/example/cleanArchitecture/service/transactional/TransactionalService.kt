package com.example.cleanArchitecture.service.transactional

import com.example.cleanArchitecture.entities.dto.request.RequestPostTransactionalEntity
import com.example.cleanArchitecture.entities.dto.response.ResponsePostTransactionalEntity


interface TransactionalService {

	fun post(body: RequestPostTransactionalEntity) : ResponsePostTransactionalEntity
}