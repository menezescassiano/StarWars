package com.cassiano.starwars.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pilot(
    @SerializedName("name") val name: String="",
    @SerializedName("avatar") val avatar: String="",
    @SerializedName("rating") val rating: Float = 0.0f): Parcelable