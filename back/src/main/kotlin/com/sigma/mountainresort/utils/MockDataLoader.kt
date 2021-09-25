package com.sigma.mountainresort.utils

import com.sigma.mountainresort.models.Detector
import com.sigma.mountainresort.models.Tourist
import com.sigma.mountainresort.repositories.TouristRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*
import kotlin.random.Random

@Component
class MockDataLoader @Autowired constructor(
        val touristRepository: TouristRepository
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val tourists = ArrayList<Tourist>()

        for(i in 1..10) {
            tourists.add(
                    Tourist(
                            UUID.randomUUID().toString(),
                            Detector(
                                    UUID.randomUUID().toString(),
                                    Random.nextDouble(0.0, 1000.0),
                                    Random.nextDouble(0.0, 1000.0)
                            ),
                            "User $i",
                            Random.nextInt(0, 10)
                    )
            )
        }

        touristRepository.saveAll(tourists)
    }
}