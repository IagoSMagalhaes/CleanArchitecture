package cleanArchitecture.service.impl

import cleanArchitecture.repository.repository.UserRepository
import com.example.cleanArchitecture.entities.dto.request.RequestDeleteUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPostUserEntity
import com.example.cleanArchitecture.entities.dto.request.RequestPutUserEntity
import com.example.cleanArchitecture.entities.dto.request.toEntity
import com.example.cleanArchitecture.entities.dto.response.ResponseGetUserEntity
import com.example.cleanArchitecture.entities.exceptions.UserDeleteException
import com.example.cleanArchitecture.entities.exceptions.UserGetException
import com.example.cleanArchitecture.entities.exceptions.UserPostException
import com.example.cleanArchitecture.entities.exceptions.UserPutException
import cleanArchitecture.repository.domain.User
import cleanArchitecture.repository.domain.toDomain
import cleanArchitecture.repository.domain.toEntity
import com.example.cleanArchitecture.service.UserService
import jdk.nashorn.internal.runtime.logging.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
@Logger
class UserServiceImpl(val repository: UserRepository) : UserService {

	val LOG = LoggerFactory.getLogger(UserServiceImpl::class.java)

	override fun get() : ResponseGetUserEntity {

		LOG.info("START GET User")

		var response = emptyList<User>()

		runCatching {

			response = repository.findAll()

		}.onFailure {

			LOG.error("ERROR GET User message: {} causeMessage: {}", it.message, it.cause!!.message)

			throw UserGetException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_GET_EXCEPTION", "user.get.exception")

		}.onSuccess {

			LOG.info("END GET User response: {}", response)

		}

		return ResponseGetUserEntity(response.toEntity())
	}

	override fun post(body: RequestPostUserEntity) {

		LOG.info("START POST User body: {}", body)

		runCatching {

			val domain = body.user.toEntity().toDomain()

			repository.save(domain)

		}.onFailure {

			LOG.error("ERROR POST User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw UserPostException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_POST_EXCEPTION", "user.post.exception")

		}.onSuccess {

			LOG.info("END POST User")

		}
	}


	override fun put(body: RequestPutUserEntity){

		LOG.info("START PUT User body: {}", body)

		runCatching {

			val domain = body.user.toEntity(1L).toDomain()

			repository.save(domain)

		}.onFailure {

			LOG.error("ERROR PUT User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw UserPutException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_PUT_EXCEPTION", "user.put.exception")

		}.onSuccess {

			LOG.info("END PUT User")

		}

	}

	override fun delete(body: RequestDeleteUserEntity){

		LOG.info("START DELETE User body: {}", body)

		runCatching {

			val response = repository.findByNameIn(body.user.name)

			repository.deleteAll(response)

		}.onFailure {

			LOG.error("ERROR DELETE User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

			throw UserDeleteException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_DELETE_EXCEPTION", "user.delete.exception")

		}.onSuccess {

			LOG.info("END DELETE User")
		}

	}
}