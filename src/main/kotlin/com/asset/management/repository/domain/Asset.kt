package com.asset.management.repository.domain

import com.asset.management.entities.domain.AssetEntity
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.Size


@Entity
@Table(schema = "public", name = "tb_asset")
class Asset (


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_asset", nullable = false)
	var id: Long? = null,

	@NotNull
	@Column(name = "name")
	@Size(min=2, max=30)
	val assetName: String? = null,


	//TODO - EVOLUIR ENUM
	//@Column(name = "type")
	//@Min(18)
//	val type: AssetType? = null,

	//@Column(name = "operation_type")
	//@Min(18)
//	val operationType: OperationType? = null,

	@Column(name = "full_value")
	val fullValue: Double? = null,

	@Column(name = "ativo")
	val active: Boolean? = null,

	//TODO - EVOLUIR RELACIONAMENTO
	@Column(name = "manager")
	val manager: String? = null,

	@Column(name = "dh_criacao")
	val dateCreate: LocalDateTime? = LocalDateTime.now(),

	@Column(name = "dh_alteracao")
	val dateUpdate: LocalDateTime? = null,

	@Column(name = "dh_exclusao")
	val dateExclude: LocalDateTime? = null)


fun List<Asset>.toEntity() = map { it.toEntity() }

fun Asset.toEntity() = AssetEntity(id = id,
								 name = assetName
								// fullValue = fullValue,
							//	 manager = manager,
								// active = active,
							//	 dateCreate = dateCreate,
							//	 dateUpdate = dateUpdate,
						//		 dateExclude = dateExclude
		 )

fun List<AssetEntity>.toDomain() = map { it.toDomain() }

fun AssetEntity.toDomain() = Asset(id = id,
	assetName = name,
	fullValue = fullValue,
	manager = manager,
	active = active,
	dateCreate = dateCreate,
	dateUpdate = dateUpdate,
	dateExclude = dateExclude)


