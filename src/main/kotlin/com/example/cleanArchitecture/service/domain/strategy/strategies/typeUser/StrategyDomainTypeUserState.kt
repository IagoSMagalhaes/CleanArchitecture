package com.example.cleanArchitecture.service.domain.strategy.strategies.typeUser

import com.example.cleanArchitecture.entities.domain.enun.DomainEnum
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import com.example.cleanArchitecture.service.domain.service.state.DomainStateServiceImpl
import com.example.cleanArchitecture.service.domain.service.typeUser.DomainTypeUserServiceImpl
import com.example.cleanArchitecture.service.domain.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
class StrategyDomainTypeUserState(override val domain: DomainEnum = DomainEnum.TYPE_USER,
                                  override val service: AbstractDomainService = DomainTypeUserServiceImpl()
) : AbstractStrategyDomain(domain, service)