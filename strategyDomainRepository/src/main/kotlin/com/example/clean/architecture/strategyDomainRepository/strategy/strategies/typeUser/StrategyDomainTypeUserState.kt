package com.example.clean.architecture.strategyDomainRepository.strategy.strategies.typeUser

import com.example.clean.architecture.entities.domain.enun.DomainEnum
import com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser.GatewayTypeUserRepository
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import com.example.clean.architecture.strategyDomainRepository.service.typeUser.DomainTypeUserServiceImpl
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainTypeUserState(override val domain: DomainEnum = DomainEnum.TYPE_USER,
                                        override val service: AbstractDomainService = DomainTypeUserServiceImpl(null)
) : AbstractStrategyDomain(domain, service)