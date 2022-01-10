package com.example.clean.architecture.controller.security.config

import com.example.clean.architecture.controller.security.service.impl.SecurityUsecaseImpl
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@EnableWebSecurity
@Configuration
open class SecurityConfig(val usecase: SecurityUsecaseImpl) : WebSecurityConfigurerAdapter() {

	@Throws(Exception::class)
	override fun configure(http: HttpSecurity) {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/swagger-ui.html/**").permitAll()
			.antMatchers(HttpMethod.POST, "/user/v1").hasAnyRole("POST_USER", "ADMIN")
			.antMatchers(HttpMethod.GET, "/user/v1").hasAnyRole("GET_ALL_USER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/user/v1").hasAnyRole("PUT_USER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, "/user/v1").hasAnyRole("DELETE_USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/landing/page/v1").permitAll()
			.and()
			.csrf().disable()
			.headers().frameOptions().disable()
	}

	@Throws(Exception::class)
	override fun configure(builder: AuthenticationManagerBuilder) {
		builder
			.userDetailsService(usecase)
			.passwordEncoder(BCryptPasswordEncoder())
	}
}