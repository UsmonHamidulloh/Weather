package com.hamidulloh.weather.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamidulloh.weather.databinding.ItemCountryBinding
import com.hamidulloh.weather.model.Country
import com.hamidulloh.weather.utils.setWeatherIcon

class CountryAdapter : ListAdapter<Country, CountryAdapter.ViewHolder>(CountryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = getItem(position)

        holder.binding.name.text = country.name
        holder.binding.temp.text = "${country.temp}°C"
        holder.binding.description.text = country.desc
        holder.binding.weather.setWeatherIcon(country.weather)
    }

    class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem.temp == newItem.temp

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem == newItem
    }

    class ViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)
}
