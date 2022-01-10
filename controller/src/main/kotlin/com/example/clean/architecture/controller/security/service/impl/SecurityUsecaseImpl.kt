package com.example.clean.architecture.controller.security.service.impl

import com.example.clean.architecture.entities.cleanArchitecture.typeUser.domain.TypeUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestGetUserEntity
import com.example.clean.architecture.usecases.service.user.UserUsecase
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class SecurityUsecaseImpl(val userUsecase: UserUsecase) : UserDetailsService {

	@Throws(UsernameNotFoundException::class)
	override fun loadUserByUsername(name: String): UserDetails {

		val user = userUsecase.getBy(RequestGetUserEntity(name = name)).first()

		return UserSystemEntity(user.name!!, user.login!!, user.password!!, authorities(user.typeUser))
	}

	private fun authorities(typeUser: TypeUserEntity?) = typeUser?.permission?.map {
					SimpleGrantedAuthority("ROLE_$it")
			}.orEmpty()
}

open class UserSystemEntity(val userSystemName: String, val userSystemLogin: String, private val userSystemPassword: String, val userSystemAuthorities: List<SimpleGrantedAuthority>) : UserDetails {

	override fun getAuthorities() = userSystemAuthorities

	override fun getPassword() = userSystemPassword

	override fun getUsername() = userSystemName

	override fun isAccountNonExpired(): Boolean {
		TODO("Not yet implemented")
	}

	override fun isAccountNonLocked(): Boolean {
		TODO("Not yet implemented")
	}

	override fun isCredentialsNonExpired(): Boolean {
		TODO("Not yet implemented")
	}

	override fun isEnabled(): Boolean {
		TODO("Not yet implemented")
	}
}