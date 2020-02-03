package com.cassiano.starwars.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.extension.observe
import com.cassiano.starwars.extension.withViewModel
import com.cassiano.starwars.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = withViewModel({ MainViewModel(application) }) {
            observe(responseData) {
                myFun()
            }
        }

        bindingContentView(R.layout.activity_main)
            .also { it.setVariable(BR.viewModel, viewModel) }
            .let { root = it.root }

        viewModel.getData()
    }

    private fun myFun() {
        println("foi!")
    }
}
