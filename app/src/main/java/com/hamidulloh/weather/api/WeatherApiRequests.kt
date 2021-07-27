package com.hamidulloh.weather.api

import com.hamidulloh.weather.model.WeatherApi
import com.hamidulloh.weather.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiRequests {
    @GET("data/2.5/weather")
    fun getWeatherData(
        @Query("q") country: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = API_KEY
    ) : Call<WeatherApi>
}