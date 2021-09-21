package com.example.cleanArchitecture.entities.domain.enun

enum class DomainEnum(val domains: List<String>) {
    BRAND(listOf("brand")),
    VEHICLE_TYPE(listOf("vehicleType")),
    CITY(listOf("city")),
    STATE(listOf("state"));
}
