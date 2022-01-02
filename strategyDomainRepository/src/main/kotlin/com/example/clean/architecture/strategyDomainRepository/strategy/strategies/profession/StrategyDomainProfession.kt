package com.example.clean.architecture.strategyDomainRepository.strategy.strategies.profession

import com.example.clean.architecture.entities.domain.enun.DomainEnum
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import com.example.clean.architecture.strategyDomainRepository.service.profession.DomainProfessionServiceImpl
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainProfession(override val domain: DomainEnum = DomainEnum.PROFESSION,
                               override val service: AbstractDomainService = DomainProfessionServiceImpl()
) : AbstractStrategyDomain(domain, service)