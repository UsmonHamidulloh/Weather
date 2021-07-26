package com.hamidulloh.weather.api

import com.hamidulloh.weather.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api: WeatherApiRequests by lazy {
        retrofit.create(WeatherApiRequests::class.java)
    }
}