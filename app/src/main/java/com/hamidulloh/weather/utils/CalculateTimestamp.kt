package com.hamidulloh.weather.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun timestampToTime(timestamp: Long): String {
    val zonedDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp),
        ZoneId.of("GMT+5")
    )
    return zonedDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"))
}