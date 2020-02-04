package com.cassiano.starwars.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Distance(
    @SerializedName("value") val value: Long = 0,
    @SerializedName("unit") val unit: String = ""
) : Parcelable