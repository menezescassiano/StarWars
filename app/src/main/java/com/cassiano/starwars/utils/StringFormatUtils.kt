package com.cassiano.starwars.utils

import android.annotation.SuppressLint
import android.content.Context
import com.cassiano.starwars.R
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
object StringFormatUtils {

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

    fun getDistanceFormated(number: Long): String {
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(number)
    }

    fun getHourMinSecFormat(context: Context, milliseconds: Int): String {
        val seconds = (milliseconds / 1000) % 60
        val minutes = (milliseconds / (1000 * 60) % 60)
        val hours = (milliseconds / (1000 * 60 * 60) % 24)

        return context.getString(R.string.hh_min_ss, hours, minutes, seconds)
    }

}