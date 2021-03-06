package com.sigma.mountainresort.services

import com.sigma.mountainresort.api.TouristDetails
import com.sigma.mountainresort.api.TouristPoint
import com.sigma.mountainresort.repositories.TouristRepository
import com.sigma.mountainresort.utils.TouristMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.random.Random

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

    @Scheduled(fixedDelay = 1000)
    fun moveTourists() {
        repository.findAll().forEach { tourist ->
            tourist.detector.latitude = minOf(tourist.detector.latitude + Random.nextDouble(-2.0, 2.0), 1000.0)
            tourist.detector.longitude = minOf(tourist.detector.longitude + Random.nextDouble(-2.0, 2.0), 1000.0)

            repository.save(tourist)
        }
    }
}