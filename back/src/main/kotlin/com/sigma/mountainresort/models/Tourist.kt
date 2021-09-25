package com.sigma.mountainresort.models

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Tourist(
        @field:Id var id: String,
        @field:OneToOne(cascade = [CascadeType.ALL]) var detector: Detector,
        var fullName: String,
        var level: Int
)