package com.example.cleanArchitecture.repository.city.repository

import com.example.cleanArchitecture.repository.city.domain.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CityRepository : JpaRepository<City, Long> {

}

