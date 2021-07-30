package com.hamidulloh.weather

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.databinding.ActivityMainBinding
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}