package com.example.clean.architecture.domainRepository.strategy.strategies.city

import com.example.clean.architecture.entities.domain.enun.DomainEnum
import com.example.clean.architecture.domainRepository.service.AbstractDomainService
import com.example.clean.architecture.domainRepository.service.city.DomainCityServiceImpl
import com.example.clean.architecture.domainRepository.strategy.impl.AbstractStrategyDomain
import org.springframework.stereotype.Service


@Service
open class StrategyDomainCity(override val domain: DomainEnum = DomainEnum.CITY,
                         override val service: AbstractDomainService = DomainCityServiceImpl()
) : AbstractStrategyDomain(domain, service)