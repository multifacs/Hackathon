package com.sigma.mountainresort.utils

import com.sigma.mountainresort.models.Detector
import com.sigma.mountainresort.models.Tourist
import com.sigma.mountainresort.repositories.TouristRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class MockDataLoader @Autowired constructor(
        val touristRepository: TouristRepository
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val tourists = listOf(
                Tourist( // correct location
                        UUID.randomUUID().toString(),
                        Detector(
                                UUID.randomUUID().toString(),
                                110.0,
                                35.0
                        ),
                        "User 1",
                        1
                ),
                Tourist( // incorrect location
                        UUID.randomUUID().toString(),
                        Detector(
                                UUID.randomUUID().toString(),
                                180.0,
                                68.0
                        ),
                        "User 2",
                        1
                )
        )
        touristRepository.saveAll(tourists)
    }
}