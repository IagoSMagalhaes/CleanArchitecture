package com.example.clean.architecture.controller.security.service

import org.springframework.security.core.userdetails.UserDetails


interface SecurityUsecase {

	fun loadUserByUsername(username: String): UserDetails
}