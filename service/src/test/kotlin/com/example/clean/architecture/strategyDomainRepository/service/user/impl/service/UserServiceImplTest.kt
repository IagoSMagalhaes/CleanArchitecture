package com.example.clean.architecture.strategyDomainRepository.service.user.impl.service

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity
import com.example.clean.architecture.repository.user.domain.User
import com.example.clean.architecture.repository.user.repository.UserRepository
import com.example.clean.architecture.strategyDomainRepository.service.user.impl.UserServiceImpl
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


@Tag("userServiceTest")
@TestConfiguration
@RunWith(MockitoJUnitRunner::class)
internal class UserServiceImplTest {

    private val repo: UserRepository = mockk()

    private val service: UserServiceImpl = UserServiceImpl(repo)

    @BeforeEach
    fun init() {
        clearMocks(repo)
    }

    @Test
    @DisplayName("Validate GET All users")
    fun `Validate GET All users call findAll`() {

        every { repo.findAll() } returns listOf()

        service.get()

        verify { repo.findAll() }
    }

    @Test
    fun `Validate POST call save`() {

        every { repo.save(any()) } returns build()

        val user = buildPost()

        service.post(user)

        verify { repo.save(any()) }
    }

    @Test
    fun `Validate PUT call save`() {

        every { repo.save(any()) } returns build()

        val user = buildPut()

        service.put(user)

        verify { repo.save(any()) }
    }

    @Test
    fun `Validate DELETE call deleteById`() {

       // every { repo.deleteById(any()) }

       // every { repo.save(any()) } returns User(id = 1, name = "Iago Magalhães")

       // doNothing().`when`<Any>(repo.deleteById(any()))
        //doNothing().`when`(repo).deleteById(any())

       //  doNothing().`when`(repo).deleteById(any())
       // `when`(repo.deleteById(any())).thenReturn(null)

        every { repo.deleteById(any()) }



        //doReturn(mockBlob).`when`(mockStorage).create(blobInfo, Files.readAllBytes(Paths.get(tempFile.getAbsolutePath())))
        //TODO - CHECK MOCK VOID METHOD
        //service.delete(1)

        //verify { repo.deleteById(any()) }
    }















    //TODO - EXTERNALIZAR PARA OUTRA CLASSE - TemplateFactoryUserTest
        fun buildPost() = RequestPostUserEntity("Iago Magalhães", "112321312", "iago@gmail.com", true, null)

        fun buildPut() = RequestPutUserEntity(1, "Iago Magalhães", "112321312", "iago@gmail.com", true)

        fun build() = User(1L, "Iago Magalhães", "", "", null, null, null, null, null)


}