package com.example.clean.architecture.domainRepository.service.profession

import com.example.clean.architecture.domainRepository.service.AbstractDomainService
import com.example.clean.architecture.entities.domain.domain.DomainEntity
import org.springframework.stereotype.Service


@Service
open class DomainProfessionServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Desenvolvedor", "Desenvolvedor"),
			DomainEntity("Engenheiro", "Engenheiro"),
			DomainEntity("Advogado", "Advogado"))

}