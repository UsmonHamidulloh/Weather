package com.hamidulloh.weather.model.api

import com.squareup.moshi.Json

data class Coord(
    @field:Json(name = "lon")
    val lon: Double,

    @field:Json(name = "lat")
    val lat: Double,
)
