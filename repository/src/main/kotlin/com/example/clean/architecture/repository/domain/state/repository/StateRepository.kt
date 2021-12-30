package com.example.clean.architecture.repository.domain.state.repository

import com.example.clean.architecture.repository.domain.state.domain.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface StateRepository : JpaRepository<State, Long> {

}

