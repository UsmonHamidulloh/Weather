package com.hamidulloh.weather

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.databinding.ActivityMainBinding
import com.hamidulloh.weather.utils.calculateDate
import com.hamidulloh.weather.utils.timestampToTime
import com.hamidulloh.weather.utils.setWeatherIcon
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}