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
    private lateinit var vModel: MainViewModel
    private lateinit var vMFactory: MainViewModelFactory
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitInstance = RetrofitInstance

        binding.requestBtn.setOnClickListener {
            vMFactory = MainViewModelFactory(retrofitInstance, binding.countryInput.text.toString())
            vModel = ViewModelProvider(this, vMFactory).get(MainViewModel::class.java)

            vModel.getData.observe(this, {
                binding.apply {
                    countryNameTxt.text = "Country: ${it.name}"
                    descTxt.text = "Description: ${it.weather[0].desc}"
                    tempTxt.text = "Temperature: ${it.main.temp}"
                }
            })
        }
    }
}