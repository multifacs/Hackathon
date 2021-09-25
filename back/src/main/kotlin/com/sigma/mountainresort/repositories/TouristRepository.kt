package com.sigma.mountainresort.repositories

import com.sigma.mountainresort.models.Tourist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TouristRepository: JpaRepository<Tourist, String> {
}