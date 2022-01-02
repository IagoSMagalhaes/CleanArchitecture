package com.example.clean.architecture.strategyDomainRepository.service.typeUser
/*
import com.example.clean.architecture.gatewayRepository.cleanArchitecture.typeUser.GatewayTypeUserRepository
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.TestConfiguration

@Tag("domainTypeUserTest")
@TestConfiguration
@RunWith(MockitoJUnitRunner::class)
internal class DomainTypeUserServiceImplTest{

    private val repo: GatewayTypeUserRepository = mockk()

    private val service: DomainTypeUserServiceImpl = DomainTypeUserServiceImpl(repo)

    @BeforeEach
    fun init() {
        clearMocks(repo)
    }

    @Test
    @DisplayName("Validate Strategy Type User")
    fun `Validate Strategy TypeUser call findAll()`() {

        every { repo.get() } returns listOf()

        service.get("typeUser", null)

        verify { repo.get() }
    }
}

 */