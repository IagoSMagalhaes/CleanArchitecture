package com.example.clean.architecture.entities.domain.enun

enum class DomainEnum(val domains: List<String>) {
    BRAND(listOf("brand")),
    TYPE_USER(listOf("typeUser")),
    CITY(listOf("city")),
    PROFESSION(listOf("profession")),
    STATE(listOf("state"));
}
