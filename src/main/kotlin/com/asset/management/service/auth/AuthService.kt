package com.example.cleanArchitecture.service.auth


interface AuthService {

	fun validate(document: String, password: String)


}