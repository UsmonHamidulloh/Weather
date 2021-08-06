package com.hamidulloh.weather.repository

import androidx.lifecycle.MutableLiveData
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.model.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainRepo(
    private val retrofitInstance: RetrofitInstance,
    private val country: String
) {

    val rWeatherReceiver = MutableLiveData<WeatherApi>()

    fun fetchData() {
        retrofitInstance.api.getWeatherData(country).enqueue(object : Callback<WeatherApi> {
            override fun onResponse(call: Call<WeatherApi>, response: Response<WeatherApi>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        rWeatherReceiver.value = body
                    }
                }
            }

            override fun onFailure(call: Call<WeatherApi>, t: Throwable) {
                Timber.d(t.localizedMessage)
            }

        })
    }
}