package com.example.clean.architecture.usecases.security.service

import org.springframework.security.core.userdetails.UserDetails


interface SecurityUsecase {

	fun loadUserByUsername(username: String): UserDetails
}