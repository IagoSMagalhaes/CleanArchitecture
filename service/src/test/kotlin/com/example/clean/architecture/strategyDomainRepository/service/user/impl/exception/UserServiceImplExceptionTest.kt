package com.example.clean.architecture.strategyDomainRepository.service.user.impl.exception

import com.example.clean.architecture.entities.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.entities.user.exception.UserDeleteException
import com.example.clean.architecture.entities.user.exception.UserGetException
import com.example.clean.architecture.entities.user.exception.UserPostException
import com.example.clean.architecture.entities.user.exception.UserPutException
import com.example.clean.architecture.repository.user.repository.UserRepository
import com.example.clean.architecture.strategyDomainRepository.service.user.impl.UserServiceImpl
import io.mockk.clearMocks
import io.mockk.mockk
import org.junit.jupiter.api.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.TestConfiguration


@Tag("userServiceExceptionTest")
@TestConfiguration
@RunWith(MockitoJUnitRunner::class)
internal class UserServiceImplExceptionTest {

    private val repo: UserRepository = mockk()

    private val service: UserServiceImpl = UserServiceImpl(repo)

    @BeforeEach
    fun init() { clearMocks(repo) }

    @Test
    @DisplayName("Validate Exception GET users")
    fun `Validate Exception GET users`() { assertThrows<UserGetException> { service.get() } }

    @Test
    @DisplayName("Validate Exception POST user")
    fun `Validate Exception POST user`() { assertThrows<UserPostException> { service.post(buildPost()) } }

    @Test
    @DisplayName("Validate Exception PUT user")
    fun `Validate Exception PUT user`() { assertThrows<UserPutException> { service.put(buildPut()) } }

    @Test
    @DisplayName("Validate Exception DELETE user")
    fun `Validate Exception DELETE user`() { assertThrows<UserDeleteException> { service.delete(1) } }








    //TODO - EXTERNALIZAR PARA OUTRA CLASSE - TemplateFactoryUserTest
        fun buildPost() = RequestPostUserEntity("Iago Magalhães", "112321312", "iago@gmail.com", true, null)

        fun buildPut() = RequestPutUserEntity(1, "Iago Magalhães", "112321312", "iago@gmail.com", true)



}