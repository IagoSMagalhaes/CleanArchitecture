package com.example.cleanArchitecture.swagger


import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
//@ComponentScan
//@EnableSwagger2
@EnableWebMvc
class SwaggerUiWebMvcConfigurer() : WebMvcConfigurer {

    private val baseUrl: String = "localhost:8085"

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        //val baseUrl: String = StringUtils.trimTrailingCharacter(baseUrl, '/')

        registry.addResourceHandler("$baseUrl/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
            .resourceChain(false)
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("$baseUrl/swagger-ui/")
            .setViewName("forward:$baseUrl/swagger-ui/index.html")
    }
}