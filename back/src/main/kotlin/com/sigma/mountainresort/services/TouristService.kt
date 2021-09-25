package com.sigma.mountainresort.services

import com.sigma.mountainresort.api.TouristDetails
import com.sigma.mountainresort.api.TouristPoint
import com.sigma.mountainresort.repositories.TouristRepository
import com.sigma.mountainresort.utils.TouristMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TouristService @Autowired constructor(
        val repository: TouristRepository,
        val mapper: TouristMapper
) {
    fun getPoints(): List<TouristPoint> {
        return repository.findAll().map(mapper::mapToPoint)
    }

    fun getDetails(id: String): TouristDetails {
        return repository.findById(id).map(mapper::mapToDetails).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}