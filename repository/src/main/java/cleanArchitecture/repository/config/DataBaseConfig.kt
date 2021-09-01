package com.example.cleanArchitecture.repository.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource


@Configuration
class DataBaseConfig(@Value("\${spring.datasource.postgre.username:postgres}") val user: String,
					 @Value("\${spring.datasource.postgre.password:postgres}") val password: String,
					 @Value("\${spring.datasource.postgre.url:jdbc:postgresql://localhost:5432/users}") val url: String,
					 @Value("\${spring.database.postgre.driverClassName:org.postgresql.Driver}") val driverClassName: String) {

	@Bean
	fun getDataSource(): DataSource? {

		val dataSource = DataSourceBuilder.create()

		dataSource.driverClassName(driverClassName)
		dataSource.url(url)
		dataSource.username(user)
		dataSource.password( password)

		return dataSource.build()

	}
}

