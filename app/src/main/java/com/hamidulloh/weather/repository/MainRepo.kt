package com.hamidulloh.weather.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.model.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo(private val retrofitInstance: RetrofitInstance) {
    val rWeatherReceiver = MutableLiveData<WeatherApi>()

    suspend fun fetchData() {
        retrofitInstance.api.getWeatherData().enqueue(object : Callback<WeatherApi> {
            override fun onResponse(call: Call<WeatherApi>, response: Response<WeatherApi>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        rWeatherReceiver.value = body
                    }
                }
            }

            override fun onFailure(call: Call<WeatherApi>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.localizedMessage}")
            }

        })
    }
}