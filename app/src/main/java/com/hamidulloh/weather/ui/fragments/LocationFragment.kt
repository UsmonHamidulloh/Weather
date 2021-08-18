package com.hamidulloh.weather.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.weather.api.RetrofitInstance
import com.hamidulloh.weather.databinding.FragmentLocationBinding
import com.hamidulloh.weather.model.Country
import com.hamidulloh.weather.model.Regions
import com.hamidulloh.weather.ui.adapter.CountryAdapter
import com.hamidulloh.weather.viewmodel.MainViewModel
import com.hamidulloh.weather.viewmodelfactory.MainViewModelFactory
import timber.log.Timber

class LocationFragment : Fragment() {
    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!

    private lateinit var cAdapter: CountryAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var vMFactory: MainViewModelFactory
    private lateinit var rInstance: RetrofitInstance
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

        val countries = ArrayList<Country>()
        rInstance = RetrofitInstance

        vMFactory = MainViewModelFactory(rInstance)
        viewModel = ViewModelProvider(this, vMFactory).get(MainViewModel::class.java)

        Regions.values().forEach { region ->
            viewModel.fetchData(region.cName)

            viewModel.getData.observe(this, {
                Timber.tag("TAG").d(it.name)
                countries.add(
                    Country(
                        name = getString(region.stringResLoc),
                        temp = it.main.temp.toInt(),
                        desc = it.weather[0].main,
                        weather = it.weather[0].icon
                    )
                )

            })
        }

        cAdapter = CountryAdapter()
        cAdapter.submitList(countries)

        binding.recyclerView.apply {
            adapter = cAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
