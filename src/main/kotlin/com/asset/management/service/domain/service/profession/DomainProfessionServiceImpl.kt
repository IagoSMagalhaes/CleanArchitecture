package com.example.cleanArchitecture.service.domain.service.profession

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
class DomainProfessionServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Desenvolvedor", "Desenvolvedor"),
			DomainEntity("Engenheiro", "Engenheiro"),
			DomainEntity("Advogado", "Advogado"))

}