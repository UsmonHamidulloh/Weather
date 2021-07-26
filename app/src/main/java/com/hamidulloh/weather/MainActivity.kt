package com.hamidulloh.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.bla_bla)
        val retrofitInstance = RetrofitInstance
        val viewModelFactory = MainViewModelFactory(retrofitInstance)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        viewModel.getData.observe(this, {
            textView.text = it.toString()
        })
    }
}