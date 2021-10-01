package com.asset.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc



@SpringBootApplication
@EnableWebMvc
<<<<<<< HEAD:src/main/kotlin/com/asset/management/Boot.kt
@ComponentScan(value = ["com.asset.management"])
@EntityScan(basePackages = ["com.asset.management.repository.domain"])
@EnableJpaRepositories(basePackages = ["com.asset.management.repository.repository"])
=======
@ComponentScan(value = ["com.example.cleanArchitecture"])
@EntityScan(basePackages = ["com.example.cleanArchitecture.repository"])
@EnableJpaRepositories(basePackages = ["com.example.cleanArchitecture.repository"])
>>>>>>> 21a26b7a45d577bc4cb108321739c7eeb97c7d06:src/main/kotlin/com/example/cleanArchitecture/Boot.kt
class Boot {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<Boot>(*args)
		}
	}

}