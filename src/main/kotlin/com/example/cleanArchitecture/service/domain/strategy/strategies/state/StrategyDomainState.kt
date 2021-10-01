package com.example.cleanArchitecture.service.domain.strategy.strategies.state

import com.example.cleanArchitecture.entities.domain.enun.DomainEnum
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import com.example.cleanArchitecture.service.domain.service.state.DomainStateServiceImpl
import com.example.cleanArchitecture.service.domain.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
class StrategyDomainState(override val domain: DomainEnum = DomainEnum.STATE,
						  override val service: AbstractDomainService = DomainStateServiceImpl()) :
	AbstractStrategyDomain(domain, service)