package com.hamidulloh.weather.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.databinding.FragmentLocationBinding
import com.hamidulloh.weather.model.Country
import com.hamidulloh.weather.model.Regions
import com.hamidulloh.weather.ui.adapter.CountryAdapter
import com.hamidulloh.weather.utils.Constants.Companion.STRING_KEY
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory
import timber.log.Timber

class LocationFragment : Fragment() {
    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!

    private lateinit var cAdapter: CountryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.backLl.setOnClickListener {
            findNavController().popBackStack()
        }

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val countries = ArrayList<Country>()

        Regions.values().forEach { region ->
            countries.add(
                Country(
                    cName = region.cName,
                    name = getString(region.stringResLoc),
                    temp = 22,
                    desc = "null",
                    weather = ""
                )
            )
        }

        cAdapter = CountryAdapter(CountryAdapter.CountryItemCallBack { country ->
            val shEditor = sharedPref?.edit()
            shEditor?.putString(STRING_KEY, country.cName)
            shEditor?.apply()
            Timber.d("shEditor.putString (key = countryName, value = ${country.cName})")

            findNavController().popBackStack()
        })

        cAdapter.submitList(countries)

        binding.recyclerView.apply {
            adapter = cAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
