package com.example.cleanArchitecture


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
@ComponentScan(value = ["com.example.cleanArchitecture"])
@EntityScan(basePackages = ["com.example.cleanArchitecture.repository.domain"])
@EnableJpaRepositories(basePackages = ["com.example.cleanArchitecture.repository.repository"])
class Boot {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<Boot>(*args)
		}
	}

}
