package com.example.cleanArchitecture

import com.example.cleanArchitecture.service.transactional.validator.RulesPostTransactional
import com.example.cleanArchitecture.service.user.UserService
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import java.util.*


@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = [UserService::class])
@SpringBootTest
class RulesPostTransactionalTest {

	@Autowired
	private val rules: RulesPostTransactional? = null

	@Test
	fun checkReturnMessageValidateStatus() {

		val response = rules!!.validateStatus("inactive")

		assert(response.isNotEmpty())

		Assertions.assertEquals(response[0], "inactive")
	}


	@Test
	fun checkExecuteValidateStatus() {

		val response = rules!!.validateStatus("inactive")

		assert(response.isNotEmpty())
	}





	@Test
	fun checkIfUpdateUser() {

		val userName: String = "Iago"

		assert(Objects.nonNull(userName))
	}

	@Test
	fun checkIfUpdateBlockedUser() {

		val userName: String = "Iago"

		assert(Objects.nonNull(userName))
	}


}
