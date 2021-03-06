package com.hamidulloh.weather.model.api

import com.squareup.moshi.Json

data class Main(
    @field:Json(name = "temp")
    val temp: Float,

    @field:Json(name = "feels_like")
    val feels_like: Float,

    @field:Json(name = "temp_min")
    val temp_min: Float,

    @field:Json(name = "temp_max")
    val temp_max: Float,

    @field:Json(name = "pressure")
    val pressure: Int,

    @field:Json(name = "humidity")
    val humidity: Int
)
