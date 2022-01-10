package com.example.clean.architecture.repository.user.domain

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(schema = "public", name = "tb_usuario")
open class User (

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user", nullable = false)
	open var id: Long? = null,

	@Column(name = "name")
	open val name: String? = null,

	@Column(name = "login")
	open val login: String? = null,

	@Column(name = "cellphone")
	open val cellphone: String? = null,

	@Column(name = "email")
	open val email: String? = null,

	@Column(name = "active")
	open val active: Boolean? = null,

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image")
	open val image: ByteArray? = null,

	@Column(name = "dh_create")
	open val dateCreate: LocalDateTime? = LocalDateTime.now(),

	@Column(name = "dh_update")
	open val dateUpdate: LocalDateTime? = null,

	@Column(name = "dh_exclude")
	open val dateExclude: LocalDateTime? = null)


fun List<User>.toEntity() = map { it.toEntity() }


fun User.toEntity() = UserEntity(id = id,
								 name = name,
								 cellphone = cellphone,
								 email = email,
								 active = active,
								 image = image,
								 dateCreate	  = dateCreate,
								 dateUpdate = dateUpdate,
								 dateExclude = dateExclude)

fun List<UserEntity>.toDomain() = map { it.toDomain() }

fun UserEntity.toDomain() = User(id = id,
								 name = name,
								 cellphone = cellphone,
								 email = email,
								 active = active,
								 image = image,
								 dateCreate = dateCreate,
								 dateUpdate = dateUpdate,
								 dateExclude = dateExclude)


