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
import timber.log.Timber

class CountryAdapter(val itemClickListener: CountryItemCallBack) :
    ListAdapter<Country, CountryAdapter.ViewHolder>(CountryDiffCallback()) {
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
        Timber.tag("TAG").d(country.weather)
        holder.binding.weather.setWeatherIcon(country.weather)

        holder.binding.root.setOnClickListener {
            itemClickListener.onItemClick(country)
        }
    }

    class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem == newItem
    }

    class CountryItemCallBack(val itemClickListener: (item: Country) -> Unit) {
        fun onItemClick(item: Country) = itemClickListener(item)
    }

    class ViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)
}
