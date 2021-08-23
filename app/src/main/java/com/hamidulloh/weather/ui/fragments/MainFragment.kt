package com.hamidulloh.weather.ui.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.databinding.FragmentMainBinding
import com.hamidulloh.weather.utils.Constants.Companion.STRING_KEY
import com.hamidulloh.weather.utils.calculateDate
import com.hamidulloh.weather.utils.setWeatherIcon
import com.hamidulloh.weather.utils.timestampToTime
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory
import timber.log.Timber

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var vMFactory: MainViewModelFactory
    private lateinit var retrofitInstance: RetrofitInstance
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    // OREO = Android version 8 (API LEVEL 26)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        retrofitInstance = RetrofitInstance
        vMFactory = MainViewModelFactory(retrofitInstance)
        viewModel = ViewModelProvider(this, vMFactory).get(MainViewModel::class.java)

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val shReceiver = sharedPref?.getString(STRING_KEY, "Tashkent")
        Timber.d("shReceiver = $shReceiver")
        Timber.d("shReceiver.getString(key = countryName, defValue = Tashkent)")

        viewModel.fetchData(shReceiver!!)

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

        binding.locationsImg.setOnClickListener {
            val navDirection = MainFragmentDirections.actionMainFragmentToLocationFragment()
            findNavController().navigate(navDirection)
        }

        binding.settingsImg.setOnClickListener {
            val navDirection = MainFragmentDirections.actionMainFragmentToSettingsFragment()
            findNavController().navigate(navDirection)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
