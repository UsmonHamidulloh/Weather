@file:Suppress("UNCHECKED_CAST")

package com.hamidulloh.weather.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.viewmodel.MainViewModel

class MainViewModelFactory(
    private val retrofitInstance: RetrofitInstance,
    private val country: String
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(retrofitInstance, country) as T

        throw IllegalAccessException("unknown view_model class")
    }
}