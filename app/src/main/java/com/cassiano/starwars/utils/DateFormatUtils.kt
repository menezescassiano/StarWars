package com.cassiano.starwars.utils

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
object DateFormatUtils {

    private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val HOUR_FORMAT = "h:mm a"

    fun getTime(date: String): String {
        val timeFormatter = SimpleDateFormat(HOUR_FORMAT)
        return timeFormatter.format(getDate(date))
    }

    private fun getDate(date: String): Date? {
        val dateFormat: DateFormat = SimpleDateFormat(DATE_FORMAT)
        return dateFormat.parse(date)
    }

}