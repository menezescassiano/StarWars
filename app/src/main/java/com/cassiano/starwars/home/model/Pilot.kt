package com.cassiano.starwars.home.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pilot(
    @SerializedName("name") val name: String="",
    @SerializedName("avatar") val avatar: String="",
    @SerializedName("rating") val rating: Float = 0.0f): Parcelable {

    fun getRatingList(): ArrayList<Boolean> {
        var count = rating.toInt()
        return ArrayList<Boolean>().apply {
            for (i in 1..5) {
                if (count > 0) {
                    add(true)
                } else {
                    add(false)
                }
                count--
            }
        }
    }
}