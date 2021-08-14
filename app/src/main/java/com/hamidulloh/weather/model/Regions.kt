package com.hamidulloh.weather.model

import com.hamidulloh.weather.R

enum class Regions(val cName: String, val stringResLoc: Int) {
    Andijan(cName = "Andijan", stringResLoc = R.string.enum_andijan),
    Bukhara(cName = "Bukhara", stringResLoc = R.string.enum_bukhara),
    Jizzakh(cName = "Jizzakh", stringResLoc = R.string.enum_jizzakh),
    Urgench(cName = "Urgench", stringResLoc = R.string.enum_urgench),
    Namangan(cName = "Namangan", stringResLoc = R.string.enum_namangan),
    Navoiy(cName = "Navoiy", stringResLoc = R.string.enum_navoiy),
    Qashqadaryo(cName = "Qashqadaryo", stringResLoc = R.string.enum_qashqadaryo),
    Samarqand(cName = "Samarqand", stringResLoc = R.string.enum_samarqand),
    Sirdaryo(cName = "Sirdaryo", stringResLoc = R.string.enum_sirdaryo),
    Surkhandarya(cName = "Surkhandarya", stringResLoc = R.string.enum_surkhandarya),
    Tashkent(cName = "Tashkent", stringResLoc = R.string.enum_tashkent),
    Karakalpakstan(cName = "Karakalpakstan", stringResLoc = R.string.enum_karakalpakstan)
}