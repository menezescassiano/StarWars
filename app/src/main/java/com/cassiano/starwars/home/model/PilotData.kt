package com.cassiano.starwars.home.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PilotData(
    @SerializedName("id") val id: Int,
    @SerializedName("pilot") val pilot: Pilot? = null,
    @SerializedName("distance") val distance: Distance? = null,
    @SerializedName("duration") val duration: Int,
    @SerializedName("pick_up") val pickUp: PickDropData? = null,
    @SerializedName("drop_off") val dropOff: PickDropData? = null
) : Parcelable