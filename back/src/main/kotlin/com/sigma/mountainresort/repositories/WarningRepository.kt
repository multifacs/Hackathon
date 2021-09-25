package com.sigma.mountainresort.repositories

import com.sigma.mountainresort.models.Warning
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface WarningRepository: JpaRepository<Warning, String> {

    @Query("select max(iteration) from Warning")
    fun findLastIterationNumber(): Int?

    @Query("select w from Warning w where w.iteration = :iteration")
    fun getWarningsFromIteration(@Param("iteration") iteration: Int): List<Warning>
}