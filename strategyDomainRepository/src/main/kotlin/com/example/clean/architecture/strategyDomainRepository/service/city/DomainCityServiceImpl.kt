package com.example.clean.architecture.strategyDomainRepository.service.city

import com.example.clean.architecture.entities.domain.domain.DomainEntity
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
open class DomainCityServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Guarulhos", "Guarulhos"),DomainEntity("São Paulo", "SP"))

}