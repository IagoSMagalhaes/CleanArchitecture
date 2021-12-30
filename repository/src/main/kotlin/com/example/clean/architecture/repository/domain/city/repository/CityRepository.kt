package com.example.clean.architecture.repository.domain.city.repository

import com.example.clean.architecture.repository.domain.city.domain.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CityRepository : JpaRepository<City, Long> {

}

