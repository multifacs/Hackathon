package com.sigma.mountainresort.api

import com.sigma.mountainresort.services.TouristService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("/tourists")
class Tourists @Autowired constructor(
        private val touristService: TouristService
){

    @ApiOperation("Получение координат туристов на карте")
    @GetMapping("/points")
    fun points() = touristService.getPoints()

    @ApiOperation("Получение детальной информации о туристах")
    @GetMapping("/{id}")
    fun details(@PathVariable id: String) = touristService.getDetails(id)
}