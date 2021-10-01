package com.example.cleanArchitecture.service.domain.service

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity


interface AbstractDomainService {

    fun get(domain: String, query: String?) : List<DomainEntity>
}
