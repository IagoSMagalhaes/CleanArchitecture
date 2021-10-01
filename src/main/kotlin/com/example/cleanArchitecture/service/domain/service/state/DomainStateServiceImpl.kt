package com.example.cleanArchitecture.service.domain.service.state

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
class DomainStateServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("São Paulo", "SP"))

}