package com.example.cleanArchitecture.repository.domain

import com.example.cleanArchitecture.controller.UserEntity
import javax.persistence.*


@Entity
@Table(schema = "public", name = "tb_usuario")
class User(val ids: Long?, val names: String) {


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	var id: Long? = null

	@Column(name = "nome")
	val name: String? = null
}


fun List<User>.toEntity() = map { it.toEntity() }

fun User.toEntity() = UserEntity(id = id, name = name)


