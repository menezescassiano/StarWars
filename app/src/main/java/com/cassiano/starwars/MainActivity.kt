package com.cassiano.starwars

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cassiano.starwars.extension.saveMainThread
import com.cassiano.starwars.network.RetrofitClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdata()
    }

    @SuppressLint("CheckResult")
    private fun getdata() {
        //RetrofitClient.getInstance().model.getTrips()
        RetrofitClient.getInstance().model.getTrips()
            .saveMainThread()
            .doOnSubscribe {
                //running.set(true)
            }
            .subscribe(
                { response ->
                    println("Ok")
                    /*running.set(false)
                    response?.vehicles?.let {
                        dataSetup(it)
                        vehiclesList = it
                    }*/
                }, {
                    //running.set(false)
                    println("not-Ok")
                })
    }
}
