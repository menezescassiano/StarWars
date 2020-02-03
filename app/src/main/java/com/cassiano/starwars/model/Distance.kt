package com.cassiano.starwars.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Distance(
    @SerializedName("value") val value: Float = 0.0f,
    @SerializedName("unit") val unit: String = ""
) : Parcelable