package com.hamidulloh.weather.model.api

import com.squareup.moshi.Json

data class WeatherApi(
    @field:Json(name = "coord")
    val coord: Coord,

    @field:Json(name = "weather")
    val weather: List<Weather>,

    @field:Json(name = "base")
    val base: String,

    @field:Json(name = "main")
    val main: Main,

    @field:Json(name = "visibility")
    val visibility: Int,

    @field:Json(name = "wind")
    val wind: Wind,

    @field:Json(name = "clouds")
    val clouds: Clouds,

    @field:Json(name = "dt")
    val dt: Long,

    @field:Json(name = "sys")
    val sys: Sys,

    @field:Json(name = "timezone")
    val timezone: Int,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "cod")
    val cod: Int
)