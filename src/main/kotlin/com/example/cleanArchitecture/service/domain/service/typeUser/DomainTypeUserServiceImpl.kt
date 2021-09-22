package com.example.cleanArchitecture.service.domain.service.typeUser

import com.example.cleanArchitecture.entities.domain.domain.DomainEntity
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
class DomainTypeUserServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Administrador", "ADM"),
			   DomainEntity("Funcionario", "FUNC"),
			   DomainEntity("Convidado", "CONV"))

}