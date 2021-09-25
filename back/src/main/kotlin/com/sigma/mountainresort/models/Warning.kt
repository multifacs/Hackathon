package com.sigma.mountainresort.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Warning(
        @field:Id var id: String,
        @field:ManyToOne var tourist: Tourist,
        var message: String,
        val type: String,
        val iteration: Int
)