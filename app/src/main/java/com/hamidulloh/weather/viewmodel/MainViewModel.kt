package com.hamidulloh.weather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.model.api.WeatherApi
import com.hamidulloh.weather.repository.MainRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val retrofitInstance: RetrofitInstance) : ViewModel() {
    private val repo = MainRepo(retrofitInstance)

    private val job = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.IO + job)

    val getData: MutableLiveData<WeatherApi> = repo.rWeatherReceiver

    fun fetchData(country: String) {
        viewModelScope.launch {
            repo.fetchData(country)
        }
    }
}