package com.example.cleanArchitecture.repository.user.repository

import com.example.cleanArchitecture.repository.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByNameIn(name: List<String>) : List<User>
}

