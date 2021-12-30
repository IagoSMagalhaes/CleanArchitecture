package com.example.clean.architecture.domainRepository.service.typeUser

import com.example.clean.architecture.domainRepository.service.AbstractDomainService
import com.example.clean.architecture.entities.domain.domain.DomainEntity
import org.springframework.stereotype.Service


@Service
open class DomainTypeUserServiceImpl() : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?) =
		listOf(DomainEntity("Administrador", "ADM"),
			   DomainEntity("Funcionario", "FUNC"),
			   DomainEntity("Convidado", "CONV"))

}