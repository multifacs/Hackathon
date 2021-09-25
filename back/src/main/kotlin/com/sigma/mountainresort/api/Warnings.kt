package com.sigma.mountainresort.api

import com.sigma.mountainresort.services.WarningService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/warnings")
class Warnings @Autowired constructor(
        private val warningService: WarningService
){

    @ApiOperation("Получение списка предупреждений")
    @GetMapping
    fun list() = warningService.getWarnings()
}