package com.example.clean.architecture.repository.user.repository

import com.example.clean.architecture.repository.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByNameIn(name: List<String>) : List<User>

    fun findByCellphoneIn(cellphone: List<String>) : List<User>

    fun findByEmailIn(email: List<String>) : List<User>
}

