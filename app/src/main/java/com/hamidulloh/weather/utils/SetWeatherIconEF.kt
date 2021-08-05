package com.hamidulloh.weather.utils

import android.widget.TextView

// EF - Extension Function
fun TextView.setWeatherIcon(icon: String) {
    when (icon) {
        // Day icons
        "01d" -> text = "1"
        "02d" -> text = "A"
        "03d" -> text = "a"
        "04d" -> text = "3"
        "09d" -> text = "M"
        "10d" -> text = "l"
        "11d" -> text = "Y"
        "13d" -> text = "I"
        "50d" -> text = "…"
        // Night icons
        "01n" -> text = "6"
        "02n" -> text = "a"
        "03n" -> text = "a"
        "04n" -> text = "3"
        "09n" -> text = "M"
        "10n" -> text = "W"
        "11n" -> text = "Y"
        "13n" -> text = "I"
        "50n" -> text = "…"
    }
}