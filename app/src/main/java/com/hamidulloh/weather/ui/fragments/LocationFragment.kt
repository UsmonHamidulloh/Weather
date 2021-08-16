package com.hamidulloh.weather.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamidulloh.weather.databinding.FragmentLocationBinding
import com.hamidulloh.weather.model.Country
import com.hamidulloh.weather.model.Regions
import com.hamidulloh.weather.ui.adapter.CountryAdapter

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

        val regions = ArrayList<Country>()

        Regions.values().sortedArray().forEach {
            regions.add(
                Country(
                    name = getString(it.stringResLoc),
                    temp = 22,
                    desc = "clear sky",
                    weather = "1"
                )
            )
        }

        cAdapter = CountryAdapter()
        cAdapter.submitList(regions)

        binding.recyclerView.apply {
            adapter = cAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}