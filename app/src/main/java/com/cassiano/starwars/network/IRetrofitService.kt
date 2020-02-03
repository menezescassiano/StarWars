package com.cassiano.starwars.network

import com.cassiano.starwars.model.Data
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface IRetrofitService {

    @GET("trips")
    fun getTrips(): Single<List<Data>>

    @GET("trips/{id}")
    fun getTripDetails(@Path("id") id: Int): Single<ResponseBody>
}