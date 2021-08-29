package com.example.cleanArchitecture.swagger

//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc

import com.example.cleanArchitecture.controller.UserController
import com.fasterxml.classmate.TypeResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.async.DeferredResult
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.RequestParameterBuilder
import springfox.documentation.builders.ResponseBuilder
import springfox.documentation.schema.AlternateTypeRules.newRule
import springfox.documentation.schema.ScalarType
import springfox.documentation.schema.WildcardType
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.*
import java.time.LocalDate
import springfox.documentation.builders.PathSelectors.*
import springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation
import javax.management.Query.not

//import com.google.common.base.Predicates.*


@Configuration
//@EnableSwagger2
class SpringFoxConfig() {

    @Autowired
    private val typeResolver: TypeResolver? = null

    /*
                    }
@Configuration
@EnableSwagger2
class SpringFoxConfig(val relativePathProvider: RelativePathProvider,
                    val servletContext: ServletContext,
                    val typeResolver: TypeResolver) {


  @Bean
  fun api(): Docket {

      val securityContext = listOf(SecurityContext.builder().securityReferences(listOf(SecurityReference("acesstoken", arrayOf()))).build())

      val securitySchemes = arrayOf(ApiKey("acesstoken", "Authorization", "header")).toList()

      return Docket(DocumentationType.SWAGGER_2)
          .pathProvider(getPath())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.example.cleanArchitecture.controller"))
          .paths(PathSelectors.any())
          .build()
          .securityContexts(securityContext)
          .securitySchemes(securitySchemes)

  }

   */

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

    @Bean
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

    @Bean
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


    @Bean
    fun petApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            //.apis(RequestHandlerSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.example.cleanArchitecture.controller"))
            //.apis(not(withClassAnnotation(UserController:class)))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .directModelSubstitute(LocalDate::class.java, String::class.java)
            .genericModelSubstitutes(ResponseEntity::class.java)
            .alternateTypeRules(
                newRule(
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
                listOf(ResponseBuilder()
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
                listOf(RequestParameterBuilder()
                    .name("someGlobalParameter")
                    .description("Description of someGlobalParameter")
                    .`in`(ParameterType.QUERY)
                    .required(true)
                    .query { q -> q.model { m -> m.scalarModel(ScalarType.STRING) } }
                    .build()))
            .tags(Tag("Pet Service", "All apis relating to pets"))
            .additionalModels(typeResolver.resolve(ApiKey::class.java))
    }


    /*
    fun getPath(): PathProvider? {

        class Rpp(servlet: ServletContext) : RelativePathProvider(servlet) {

            override fun getApplicationBasePath() = "/"
        }

        return Rpp(servletContext)
    }

     */


    //fun apiInfo
}