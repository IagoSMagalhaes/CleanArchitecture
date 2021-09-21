package com.example.cleanArchitecture.service.domain.service.city

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
class DomainCityServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Guarulhos", "Guarulhos"),DomainEntity("São Paulo", "SP"))

}