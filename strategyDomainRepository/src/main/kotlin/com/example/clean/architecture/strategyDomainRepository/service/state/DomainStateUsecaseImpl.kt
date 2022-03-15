package com.example.clean.architecture.strategyDomainRepository.service.state

import com.example.clean.architecture.repository.domain.state.domain.toDomainEntity
import com.example.clean.architecture.repository.domain.state.domain.toEntity
import com.example.clean.architecture.repository.domain.state.repository.StateRepository
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
open class DomainStateUsecaseImpl(val repository: StateRepository) : AbstractDomainService {

	override fun get(domain: String, query: String?) =
		repository.findAll().toEntity().toDomainEntity()

}

