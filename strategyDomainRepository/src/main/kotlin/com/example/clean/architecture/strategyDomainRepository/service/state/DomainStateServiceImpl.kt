package com.example.clean.architecture.strategyDomainRepository.service.state

import com.example.clean.architecture.entities.domain.domain.DomainEntity
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
open class DomainStateServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("São Paulo", "SP"))

}