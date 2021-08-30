package com.example.cleanArchitecture

import com.example.cleanArchitecture.controller.UserController
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
@EnableAutoConfiguration(exclude= [DataSourceAutoConfiguration::class])
@EnableSwagger2
@ComponentScan(basePackageClasses = [UserController::class], value = ["com.example.cleanArchitecture"])
//@EntityScan(basePackages = ["com.example.cleanArchitecture.repository.domain"])
//@EnableJpaRepositories(basePackages = ["com.example.cleanArchitecture.repository.repository"])
class CleanArchitectureApplication {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<CleanArchitectureApplication>(*args)
		}
	}

}

fun main(args: Array<String>) {
	runApplication<CleanArchitectureApplication>(*args)
}