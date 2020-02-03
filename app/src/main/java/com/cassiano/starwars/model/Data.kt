package com.cassiano.starwars.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Data(
    @SerializedName("id") val id: Int,
    @SerializedName("pilot") val pilot: Pilot? = null,
    @SerializedName("distance") val distance: Distance? = null,
    @SerializedName("duration") val duration: Float = 0.0f,
    @SerializedName("pick_up") val pickUp: PickDropData? = null,
    @SerializedName("drop_off") val dropOff: PickDropData? = null
) : Parcelable {

    /*
    *   {
    "id": 1,
    "pilot": {
      "name": "Dark Vador",
      "avatar": "/static/dark-vador.png",
      "rating": 5.0
    },
    "distance": {
      "value": 2478572,
      "unit": "km"
    },
    "duration": 19427000,
    "pick_up": {
      "name": "Yavin 4",
      "picture": "/static/yavin-4.png",
      "date": "2017-12-09T14:12:51Z"
    },
    "drop_off": {
      "name": "Naboo",
      "picture": "/static/naboo.png",
      "date": "2017-12-09T19:35:51Z"
    }
  }*/
}