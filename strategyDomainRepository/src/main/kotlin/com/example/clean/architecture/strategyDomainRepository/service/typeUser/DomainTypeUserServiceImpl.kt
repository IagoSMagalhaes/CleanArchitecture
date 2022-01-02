package com.example.clean.architecture.strategyDomainRepository.service.typeUser

import com.example.clean.architecture.entities.domain.domain.DomainEntity
import com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser.GatewayTypeUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import org.springframework.stereotype.Service


@Service
open class DomainTypeUserServiceImpl(val gatewayTypeUser: GatewayTypeUserRepository?) : AbstractDomainService {

	//TODO - IMPLEMENTAR BUSCANDO DO REPOSITORY
	override fun get(domain: String, query: String?): List<DomainEntity> {

		val typeUser = gatewayTypeUser?.get()

		//return typeUser?.map { DomainEntity("Administrador", "ADM") }

		//TODO - CARREGAR DO REP
		return listOf(DomainEntity("Administrador", "ADM"),
					  DomainEntity("Funcionario", "FUNC"),
					  DomainEntity("Convidado", "CONV"))
	}


}