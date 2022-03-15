package com.example.clean.architecture.repository.domain.state.domain

import com.example.clean.architecture.entities.repositoryDomain.state.domain.StateEntity
import com.sun.istack.NotNull
import javax.persistence.*

//import javax.validation.constraints.Size


@Entity
@Table(schema = "public", name = "tb_state")
open class State (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_state", nullable = false)
	open var id : Long? = null,

	@NotNull
	@Column(name = "full_name")
	//@Size(min=2, max=30)
	open val fullName: String? = null,

	//TODO - EVOLUIR ENUM
	@Column(name = "initials")
	open val initials: String? = null)



fun List<State>.toEntity() = map { it.toEntity() }

fun State.toEntity() = StateEntity(id = id,
								 fullName = fullName,
								 initials = initials
								 //dateCreate = dateCreate,
								 //dateUpdate = dateUpdate,
								 //dateExclude = dateExclude
		 )

//fun List<StateEntity>.toDomain() = map { it.toDomain() }


fun List<StateEntity>.toDomainEntity() = map { it.toDomainEntity() }

fun StateEntity.toDomainEntity() = com.example.clean.architecture.entities.otherRepositories.domain.domain.DomainEntity(
	label = fullName,
	value = initials)

