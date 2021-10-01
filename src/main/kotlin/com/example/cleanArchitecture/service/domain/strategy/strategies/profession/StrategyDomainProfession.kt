package com.example.cleanArchitecture.service.domain.strategy.strategies.profession

import com.example.cleanArchitecture.entities.domain.enun.DomainEnum
import com.example.cleanArchitecture.service.domain.service.AbstractDomainService
import com.example.cleanArchitecture.service.domain.service.city.DomainCityServiceImpl
import com.example.cleanArchitecture.service.domain.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
class StrategyDomainProfession(override val domain: DomainEnum = DomainEnum.PROFESSION,
                               override val service: AbstractDomainService = DomainCityServiceImpl()
) : AbstractStrategyDomain(domain, service)