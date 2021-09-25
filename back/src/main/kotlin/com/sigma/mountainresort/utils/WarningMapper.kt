package com.sigma.mountainresort.utils

import com.sigma.mountainresort.api.WarningMessage
import com.sigma.mountainresort.models.Warning
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(componentModel = "spring")
interface WarningMapper {

    @Mappings(
            Mapping(source = "tourist.fullName", target = "touristName"),
            Mapping(source = "tourist.id", target = "touristId"),
            Mapping(source = "tourist.detector.latitude", target = "latitude"),
            Mapping(source = "tourist.detector.longitude", target = "longitude")
    )
    fun mapToDto(warning: Warning): WarningMessage
}