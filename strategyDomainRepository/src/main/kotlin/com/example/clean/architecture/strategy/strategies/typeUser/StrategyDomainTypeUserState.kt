package com.example.clean.architecture.domainRepository.strategy.strategies.typeUser

import com.example.clean.architecture.entities.domain.enun.DomainEnum
import com.example.clean.architecture.domainRepository.service.AbstractDomainService
import com.example.clean.architecture.domainRepository.service.typeUser.DomainTypeUserServiceImpl
import com.example.clean.architecture.domainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainTypeUserState(override val domain: DomainEnum = DomainEnum.TYPE_USER,
                                  override val service: AbstractDomainService = DomainTypeUserServiceImpl()
) : AbstractStrategyDomain(domain, service)