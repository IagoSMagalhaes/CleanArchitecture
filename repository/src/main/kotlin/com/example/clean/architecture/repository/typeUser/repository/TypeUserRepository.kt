package com.example.clean.architecture.repository.typeUser.repository

import com.example.clean.architecture.repository.typeUser.domain.TypeUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TypeUserRepository : JpaRepository<TypeUser, Long> {

}

