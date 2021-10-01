package com.example.cleanArchitecture.repository.state.repository

import com.example.cleanArchitecture.repository.state.domain.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface StateRepository : JpaRepository<State, Long> {

}

