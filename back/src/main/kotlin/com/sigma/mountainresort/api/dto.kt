package com.sigma.mountainresort.api

class TouristPoint(
        val id: String,
        val latitude: Double,
        val longitude: Double
)

class TouristDetails(
        val id: String,
        val fullName: String,
        val level: Int,
        val detectorId: String,
        val latitude: Double,
        val longitude: Double
)

class WarningMessage(
        val touristId: String,
        val latitude: Double,
        val longitude: Double,
        val message: String
)