package com.example.cleanArchitecture

import com.example.cleanArchitecture.controller.UserController
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import springfox.documentation.swagger2.annotations.EnableSwagger2

//import org.springframework.web.servlet.config.annotation.EnableWebMvc


/*
@SpringBootApplication
@EnableAutoConfiguration(exclude= [DataSourceAutoConfiguration::class])
//@EnableWebMvc
//@EnableSwagger2
@ComponentScan(basePackageClasses = [UserController::class], value = ["com.example"])
class CleanArchitectureApplication {

}

fun main(args: Array<String>) {
	runApplication<CleanArchitectureApplication>(*args)
}


 */

@SpringBootApplication
@EnableAutoConfiguration(exclude= [DataSourceAutoConfiguration::class])
//@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackageClasses = [UserController::class], value = ["com.example"])
class CleanArchitectureApplication {

	/*
	@Autowired
	private val typeResolver: TypeResolver? = null

	fun apiKey(): ApiKey? {
		return ApiKey("mykey", "api_key", "header")
	}

	fun defaultAuth(): List<SecurityReference?>? {
		val authorizationScope = AuthorizationScope("global", "accessEverything")
		val authorizationScopes: Array<AuthorizationScope?> = arrayOfNulls<AuthorizationScope>(1)
		authorizationScopes[0] = authorizationScope
		return listOf(
			SecurityReference("mykey", authorizationScopes)
		)
	}

	fun securityContext(): SecurityContext? {
		return SecurityContext.builder()
			.securityReferences(defaultAuth())
			.forPaths(PathSelectors.regex("/anyPath.*"))
			.build()
	}

	//@Bean
	fun security(): SecurityConfiguration? {
		return SecurityConfigurationBuilder.builder()
			.clientId("test-app-client-id")
			.clientSecret("test-app-client-secret")
			.realm("test-app-realm")
			.appName("test-app")
			.scopeSeparator(",")
			.additionalQueryStringParams(null)
			.useBasicAuthenticationWithAccessCodeGrant(false)
			.enableCsrfSupport(false)
			.build()
	}

	//@Bean
	fun uiConfig(): UiConfiguration? {
		return UiConfigurationBuilder.builder()
			.deepLinking(true)
			.displayOperationId(false)
			.defaultModelsExpandDepth(1)
			.defaultModelExpandDepth(1)
			.defaultModelRendering(ModelRendering.EXAMPLE)
			.displayRequestDuration(false)
			.docExpansion(DocExpansion.NONE)
			.filter(false)
			.maxDisplayedTags(null)
			.operationsSorter(OperationsSorter.ALPHA)
			.showExtensions(false)
			.showCommonExtensions(false)
			.tagsSorter(TagsSorter.ALPHA)
			.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
			.validatorUrl(null)
			.build()
	}


	//@Bean
	fun petApi(): Docket? {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build()
			.pathMapping("/")
			.directModelSubstitute(LocalDate::class.java, String::class.java)
			.genericModelSubstitutes(ResponseEntity::class.java)
			.alternateTypeRules(
				AlternateTypeRules.newRule(
					typeResolver!!.resolve(
						DeferredResult::class.java,
						typeResolver.resolve(ResponseEntity::class.java, WildcardType::class.java)
					),
					typeResolver.resolve(WildcardType::class.java)
				)
			)
			.useDefaultResponseMessages(false)
			.globalResponses(
				HttpMethod.GET,
				listOf(
					ResponseBuilder()
					.code("500")
					.description("500 message")
					.representation(MediaType.TEXT_XML)
					.apply { r ->
						r.model { m ->
							m.referenceModel { ref ->
								ref.key { k ->
									k.qualifiedModelName { q ->
										q.namespace("some:namespace")
											.name("ERROR")
									}
								}
							}
						}
					}
					.build()))
			.securitySchemes(listOf(apiKey()))
			.securityContexts(listOf(securityContext()))
			.enableUrlTemplating(true)
			.globalRequestParameters(
				listOf(
					RequestParameterBuilder()
					.name("someGlobalParameter")
					.description("Description of someGlobalParameter")
					.`in`(ParameterType.QUERY)
					.required(true)
					.query { q -> q.model { m -> m.scalarModel(ScalarType.STRING) } }
					.build()))
			.tags(Tag("Pet Service", "All apis relating to pets"))
			.additionalModels(typeResolver.resolve(ApiKey::class.java))
	}


	 */
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