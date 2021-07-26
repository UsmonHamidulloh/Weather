package com.hamidulloh.weather.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.viewmodel.MainViewModel

class MainViewModelFactory(private val retrofitInstance: RetrofitInstance) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(retrofitInstance) as T

        throw IllegalAccessException("unknown view_model class")
    }
}