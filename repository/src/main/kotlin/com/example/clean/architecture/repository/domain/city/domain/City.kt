package com.example.clean.architecture.repository.domain.city.domain

import com.sun.istack.NotNull
import javax.persistence.*
//import javax.validation.constraints.Size


@Entity
@Table(schema = "public", name = "tb_city")
open class City (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_city", nullable = false)
	open var id: Long? = null,

	@NotNull
	@Column(name = "full_name")
	//@Size(min=2, max=30)
	open val fullName: String? = null,


	//TODO - EVOLUIR ENUM
	@Column(name = "initials")
	open val initials: String? = null)

/*

fun List<Asset>.toEntity() = map { it.toEntity() }

fun Asset.toEntity() = AssetEntity(id = id,
								 name = assetName,
								 fullValue = fullValue,
								type = type,
								 manager = manager
								// active = active,
							//	 dateCreate = dateCreate,
							//	 dateUpdate = dateUpdate,
						//		 dateExclude = dateExclude
		 )

fun List<AssetEntity>.toDomain() = map { it.toDomain() }

fun AssetEntity.toDomain() = Asset(id = id,
	assetName = name,
	type = type,
	fullValue = fullValue,
	manager = manager,
	active = active,
	dateCreate = dateCreate,
	dateUpdate = dateUpdate,
	dateExclude = dateExclude)




 */