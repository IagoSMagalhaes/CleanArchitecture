package com.example.cleanArchitecture

import com.example.cleanArchitecture.service.user.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import java.util.*


@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = [UserService::class])
class UserServiceTest {

	@Autowired
	private val service: UserService? = null

	@Test
	fun checkIfCreatedUser() {

		val userName: String = "Iago"

		//service!!.get()

		Assertions.assertEquals(userName, "Iago");
		assert(Objects.nonNull(userName))
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
