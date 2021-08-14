package com.hamidulloh.weather.model.api

import com.squareup.moshi.Json

data class Sys(
    @field:Json(name = "type")
    val type: Int,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "country")
    val country: String,

    @field:Json(name = "sunrise")
    val sunrise: Long,

    @field:Json(name = "sunset")
    val sunset: Long
)
