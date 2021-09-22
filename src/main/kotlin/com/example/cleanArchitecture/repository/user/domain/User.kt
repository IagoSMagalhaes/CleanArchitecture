package com.example.cleanArchitecture.repository.user.domain

import com.example.cleanArchitecture.entities.user.domain.UserEntity
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.Size


@Entity
@Table(schema = "public", name = "tb_usuario")
class User (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	var id: Long? = null,

	@NotNull
	@Column(name = "nome")
	@Size(min=2, max=30)
	val name: String? = null,

	@Column(name = "telefone")
	@Min(18)
	val cellphone: String? = null,

	@Column(name = "email")
	val email: String? = null,

	@Column(name = "ativo")
	val active: Boolean? = null,

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image")
	val image: ByteArray? = null,

	@Column(name = "dh_criacao")
	val dateCreate: LocalDateTime? = LocalDateTime.now(),

	@Column(name = "dh_alteracao")
	val dateUpdate: LocalDateTime? = null,


	@Column(name = "dh_exclusao")
	val dateExclude: LocalDateTime? = null)


fun List<User>.toEntity() = map { it.toEntity() }

fun User.toEntity() = UserEntity(id = id,
								 name = name,
								 cellphone = cellphone,
								 email = email,
								 active = active,
								 image = image,
								 dateCreate = dateCreate,
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


