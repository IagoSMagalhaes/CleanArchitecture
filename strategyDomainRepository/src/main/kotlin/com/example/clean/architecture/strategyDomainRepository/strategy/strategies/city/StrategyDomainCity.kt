package com.example.clean.architecture.strategyDomainRepository.strategy.strategies.city

import com.example.clean.architecture.entities.otherRepositories.domain.enun.DomainEnum
import com.example.clean.architecture.strategyDomainRepository.service.AbstractDomainService
import com.example.clean.architecture.strategyDomainRepository.service.city.DomainCityServiceImpl
import com.example.clean.architecture.strategyDomainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainCity(override val domain: DomainEnum = DomainEnum.CITY,
                         override val service: AbstractDomainService = DomainCityServiceImpl()
) : AbstractStrategyDomain(domain, service)