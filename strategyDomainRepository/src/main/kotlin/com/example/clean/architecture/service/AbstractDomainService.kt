package com.example.clean.architecture.domainRepository.service

import com.example.clean.architecture.entities.domain.domain.DomainEntity


interface AbstractDomainService {

    fun get(domain: String, query: String?) : List<DomainEntity>
}
