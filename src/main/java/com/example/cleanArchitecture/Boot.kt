package com.example.cleanArchitecture

//import com.example.cleanArchitecture.web.swagger.SwaggerConfig
import com.example.cleanArchitecture.repository.repository.UserRepository
import com.example.cleanArchitecture.web.swagger.SwaggerConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@SpringBootApplication(scanBasePackages = ["com.example.cleanArchitecture.web.swagger", " com.example.cleanArchitecture.repository.repository"])
@EnableWebMvc
@ComponentScan(value = ["com.example.com.example.cleanArchitecture", "com.example.cleanArchitecture.web.swagger"])
//@ComponentScan(basePackageClasses = [SwaggerConfig::class, UserRepository::class], value = ["com.example.com.example.cleanArchitecture", "com.example.cleanArchitecture.web.swagger"])
//@EntityScan(basePackages = ["com.example.com.example.cleanArchitecture.repository.domain"])
//@EnableJpaRepositories(basePackages = ["com.example.com.example.cleanArchitecture.repository.repository"])
@EnableAutoConfiguration(exclude=[DataSourceAutoConfiguration::class])
class Boot {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<Boot>(*args)
		}
	}



}
/*
@Configuration
@EnableSwagger2
class SwaggerConfig : WebMvcConfigurationSupport() {
	@Bean
	fun greetingApi(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.cleanArchitecture.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(metaData())
	}

	private fun metaData(): ApiInfo {
		return ApiInfoBuilder()
			.title("Spring Boot REST API")
			.description("\"Spring Boot REST API for greeting people\"")
			.version("1.0.0")
			.license("Apache License Version 2.0")
			.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
			.build()
	}

	override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/")

		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/")
	}

}








 */