package com.example.cleanArchitecture.service


interface UserService {

	fun get() : List<String>

	fun post()

	fun put()

	fun delete()
}