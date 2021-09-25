package com.sigma.mountainresort.services

import com.sigma.mountainresort.models.Tourist
import com.sigma.mountainresort.models.Warning
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*

interface WarningChecker {
    fun check(tourist: Tourist, iteration: Int): Warning?
}

@ConfigurationProperties(prefix = "warns.square")
class SquareConfig {
    var minLatitude: Double? = null
    var maxLatitude: Double? = null
    var minLongitude: Double? = null
    var maxLongitude: Double? = null
    var level: Int? = null
}

@Component
@EnableConfigurationProperties(SquareConfig::class)
class SquareWarningChecker @Autowired constructor(
        private val square: SquareConfig
    ) : WarningChecker {

    companion object {
        private const val NOT_IN_SQUARE = "NOT_IN_SQUARE"
        private const val IN_SQUARE_WITH_HIGHTER_LEVEL = "IN_SQUARE_WITH_HIGHTER_LEVEL"
    }

    override fun check(tourist: Tourist, iteration: Int): Warning? {
        return if (tourist.detector.latitude !in square.minLatitude!!..square.maxLatitude!! ||
                tourist.detector.longitude !in square.minLongitude!!..square.maxLongitude!!) {
            Warning(
                    UUID.randomUUID().toString(),
                    tourist,
                    "Турист вышел за пределы зоны",
                    NOT_IN_SQUARE,
                    iteration
            )
        } else {
            if (square.level != null && square.level!! > tourist.level) {
                Warning(
                        UUID.randomUUID().toString(),
                        tourist,
                        "Турист находится в зоне с более высоким уровнем",
                        IN_SQUARE_WITH_HIGHTER_LEVEL,
                        iteration
                )
            } else {
                null
            }
        }
    }
}