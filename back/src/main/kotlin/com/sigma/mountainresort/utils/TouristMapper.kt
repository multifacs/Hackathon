package com.sigma.mountainresort.utils

import com.sigma.mountainresort.api.TouristDetails
import com.sigma.mountainresort.api.TouristPoint
import com.sigma.mountainresort.models.Tourist
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface TouristMapper {

    @Mappings(
            Mapping(source = "detector.latitude", target = "latitude"),
            Mapping(source = "detector.longitude", target = "longitude")
    )
    fun mapToPoint(tourist: Tourist): TouristPoint

    @Mappings(
            Mapping(source = "detector.latitude", target = "latitude"),
            Mapping(source = "detector.longitude", target = "longitude"),
            Mapping(source = "detector.id", target = "detectorId")
    )
    fun mapToDetails(tourist: Tourist): TouristDetails
}