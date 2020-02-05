package com.cassiano.starwars.network

import com.cassiano.starwars.home.model.PilotData
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface IRetrofitService {

    @GET("trips")
    fun getTrips(): Single<List<PilotData>>

    @GET("trips/{id}")
    fun getTripDetails(@Path("id") id: Int): Single<ResponseBody>
}