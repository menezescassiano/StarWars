package com.cassiano.starwars.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cassiano.starwars.extension.saveMainThread
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.network.RetrofitClient

class MainViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var list: ArrayList<PilotData>
    val responseData: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getData() {
        //RetrofitClient.getInstance().model.getTrips()
        RetrofitClient.getInstance().model.getTrips()
            .saveMainThread()
            .doOnSubscribe {
                //running.set(true)
            }
            .subscribe(
                { response ->
                    list = response as ArrayList<PilotData>
                    responseData.postValue(true)
                }, {
                    //running.set(false)
                    println("not-Ok")
                })
    }
}