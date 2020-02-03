package com.cassiano.starwars.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cassiano.starwars.extension.saveMainThread
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.network.RetrofitClient

class MainViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var list: ArrayList<PilotData>
    val responseData: MutableLiveData<Boolean> = MutableLiveData()
    private val running = ObservableBoolean(false)
    val progressVisibility = ObservableInt(0)

    @SuppressLint("CheckResult")
    fun getData() {
        RetrofitClient.getInstance().model.getTrips()
            .saveMainThread()
            .doOnSubscribe {
                running.set(true)
                setShowProgressBar()
            }
            .doFinally {
                running.set(false)
                setShowProgressBar()
            }
            .subscribe(
                { response ->
                    list = response as ArrayList<PilotData>
                    responseData.postValue(true)
                }, {
                    println("not-Ok")
                })
    }

    private fun setShowProgressBar() {
        if (running.get()) {
            progressVisibility.set(View.VISIBLE)
        } else {
            progressVisibility.set(View.GONE)
        }
    }
}