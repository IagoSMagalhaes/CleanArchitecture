package com.example.clean.architecture.repository.typeUser.domain

import com.example.clean.architecture.entities.cleanArchitecture.typeUser.domain.TypeUserEntity
import com.sun.istack.NotNull
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(schema = "public", name = "tb_type_user")
@TypeDefs(value = [TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)])
open class TypeUser (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_type_user", nullable = false)
	open var id: Long? = null,

	@NotNull
	@Column(name = "name")
	open val name: String? = null,

	@NotNull
	@Column(name = "sg")
	open val sg: String? = null,

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	open val permission: List<String>? = emptyList(),

	@Column(name = "active")
	open val active: Boolean? = null,

	@Column(name = "dh_create")
	open val dateCreate: LocalDateTime? = LocalDateTime.now(),

	@Column(name = "dh_update")
	open val dateUpdate: LocalDateTime? = null,

	@Column(name = "dh_exclude")
	open val dateExclude: LocalDateTime? = null)


fun List<TypeUser>.toEntity() = map { it.toEntity() }

fun TypeUser.toEntity() = TypeUserEntity(id = id,
								 name = name,
								permission = permission,
								sg = sg,
								 active = active,
								 dateCreate	  = dateCreate,
								 dateUpdate = dateUpdate,
								 dateExclude = dateExclude)

fun List<TypeUserEntity>.toDomain() = map { it.toDomain() }

fun TypeUserEntity.toDomain() = TypeUser(id = id,
								 name = name,
								 permission = permission,
								 sg = sg,
								 active = active,
								 dateCreate = dateCreate,
								 dateUpdate = dateUpdate,
								 dateExclude = dateExclude)


