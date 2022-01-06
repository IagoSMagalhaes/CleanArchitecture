package com.example.clean.architecture.repository.user.domain

import com.example.clean.architecture.entities.cleanArchitecture.user.domain.UserEntity
import com.example.clean.architecture.entities.otherRepositories.ldap.user.dto.request.RequestPostLdapUserEntity
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(schema = "public", name = "tb_usuario")
open class User (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	open var id: Long? = null,

	@NotNull
	@Column(name = "nome")
	//@Size(min=2, max=30)
	open val name: String? = null,

	@Column(name = "telefone")
	//@Min(18)
	open val cellphone: String? = null,

	@Column(name = "email")
	open val email: String? = null,

	@Column(name = "ativo")
	open val active: Boolean? = null,

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "image")
	open val image: ByteArray? = null,

	@Column(name = "dh_criacao")
	open val dateCreate: LocalDateTime? = LocalDateTime.now(),

	@Column(name = "dh_alteracao")
	open val dateUpdate: LocalDateTime? = null,


	@Column(name = "dh_exclusao")
	open val dateExclude: LocalDateTime? = null)


fun List<User>.toEntity() = map { it.toEntity() }


fun User.toRequestPostLdapUserEntity() = RequestPostLdapUserEntity( name!!, "001122")

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


