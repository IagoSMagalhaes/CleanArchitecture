package com.example.clean.architecture.strategyDomainRepository.strategy.strategies.state

import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import com.example.clean.architecture.strategyDomainRepository.service.state.DomainStateUsecaseImpl
import com.example.clean.architecture.entities.otherRepositories.domain.enun.DomainEnum
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainState(override val domain: DomainEnum = DomainEnum.STATE,
						  override val service: AbstractDomainService = DomainStateUsecaseImpl()
) : AbstractStrategyDomain(domain, service)