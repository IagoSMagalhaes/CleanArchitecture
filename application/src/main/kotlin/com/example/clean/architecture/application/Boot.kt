package com.example.clean.architecture.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@ComponentScan(value = ["com.example.clean.architecture"])
@EntityScan(basePackages = ["com.example.clean.architecture.repository"])
@EnableJpaRepositories(basePackages = ["com.example.clean.architecture.repository"])
open class Boot {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<Boot>(*args)
		}
	}

}