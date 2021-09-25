package com.sigma.mountainresort.services

import com.sigma.mountainresort.api.WarningMessage
import com.sigma.mountainresort.repositories.TouristRepository
import com.sigma.mountainresort.repositories.WarningRepository
import com.sigma.mountainresort.utils.WarningMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class WarningService @Autowired constructor(
        private val warningRepository: WarningRepository,
        private val checkers: List<WarningChecker>,
        private val touristRepository: TouristRepository,
        private val mapper: WarningMapper
) {

    private fun getLastIterationNum() = warningRepository.findLastIterationNumber() ?: 0

    @Scheduled(fixedDelay = 5000)
    fun performCheck() {
        val iterationNumber = getLastIterationNum() + 1
        val warnings = touristRepository.findAll().flatMap { tourist ->
            checkers.map { it.check(tourist, iterationNumber) }
        }.filterNotNull()

        warningRepository.saveAll(warnings)
    }

    fun getWarnings(): List<WarningMessage> {

        return warningRepository.getWarningsFromIteration(getLastIterationNum()).map(mapper::mapToDto)
    }
}