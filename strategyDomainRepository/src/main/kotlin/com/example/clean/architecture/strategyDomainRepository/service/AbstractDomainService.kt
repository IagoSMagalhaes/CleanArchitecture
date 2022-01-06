package com.example.clean.architecture.strategyDomainRepository.service

import com.example.clean.architecture.entities.otherRepositories.domain.domain.DomainEntity


interface AbstractDomainService {

    fun get(domain: String, query: String?) : List<DomainEntity>
}
