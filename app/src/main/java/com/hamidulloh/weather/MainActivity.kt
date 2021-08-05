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
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var vMFactory: MainViewModelFactory
    private lateinit var retrofitInstance: RetrofitInstance

    // OREO = Android version 8
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitInstance = RetrofitInstance
        vMFactory = MainViewModelFactory(
            retrofitInstance = retrofitInstance,
            country = "Tashkent"
        )
        viewModel = ViewModelProvider(this, vMFactory).get(MainViewModel::class.java)

        binding.dateTxt.text = calculateDate()
        viewModel.getData.observe(this, { weather ->
            // Location name
            binding.locationTxt.text = weather.name
            // Temperature
            binding.tempTxt.text = weather.main.temp.toInt().toString()
            // Maximal temp and Minimal temp
            binding.minTempTxt.text = weather.main.temp_min.toString()
            binding.maxTempTxt.text = weather.main.temp_max.toString()
            // Weather description
            binding.weatherTitleTxt.text = weather.weather[0].desc
            // Sunrise and Sunset
            binding.sunriseTxt.text = timestampToTime(weather.sys.sunrise)
            binding.sunsetTxt.text = timestampToTime(weather.sys.sunset)
            // Weather icon
            binding.weatherIconImg.setWeatherIcon(weather.weather[0].icon)
        })
    }
}