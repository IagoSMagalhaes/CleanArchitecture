package com.example.cleanArchitecture.service.city.impl

import com.asset.management.entities.repositoryDomain.city.dto.request.RequestPostCitytEntity
import com.example.cleanArchitecture.repository.city.domain.City
import com.example.cleanArchitecture.repository.city.repository.CityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class CityServiceImpl(val cityRepository: CityRepository
) {

	val LOG = LoggerFactory.getLogger(CityServiceImpl::class.java)

	fun post(body: RequestPostCitytEntity) {

		LOG.info("START POST City " + body.fullname)

		runCatching {
			if(body.fullname == null){
				throw Exception();
			}
			val citySave = City(initials = body.initials, fullName = body.fullname);

			cityRepository.save(citySave)

		}.onFailure {
			LOG.error("ERROR POST CITY message: {} causeMessage: {}", it.message, it.cause!!.message)

			throw Exception()

		}.onSuccess {
			LOG.info("END POST City response: {}")

		}
	}
}