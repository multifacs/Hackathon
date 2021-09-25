package com.sigma.mountainresort.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Detector(
       @field:Id var id: String,
       var latitude: Double,
       var longitude: Double,
       @field:OneToOne(mappedBy = "detector") var tourist: Tourist? = null
)