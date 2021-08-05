package com.hamidulloh.weather.utils

import java.util.*

fun calculateDate(): String {
    val calendarInstance = Calendar.getInstance()
    val weekOfMonth = calculateWeek(calendarInstance.get(Calendar.DAY_OF_WEEK))
    val day = calendarInstance.get(Calendar.DAY_OF_MONTH)
    val month = calculateMonth(calendarInstance.get(Calendar.MONTH))
    val year = calendarInstance.get(Calendar.YEAR)

    return "$weekOfMonth, $day $month $year"
}

fun calculateWeek(index: Int): String {
    val weeks = arrayListOf(
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
    )
    // array is starter from zero
    return weeks[index - 1]
}

private fun calculateMonth(index: Int): String {
    val months = arrayListOf(
        "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"
    )
    return months[index]
}
