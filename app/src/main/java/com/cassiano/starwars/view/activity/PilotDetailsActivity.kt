package com.cassiano.starwars.view.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityMainBinding
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.extension.observe
import com.cassiano.starwars.extension.withViewModel
import com.cassiano.starwars.model.Pilot
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.viewmodel.MainViewModel
import com.cassiano.starwars.viewmodel.PilotDetailsViewModel
import kotlinx.android.synthetic.main.activity_pilot_details.*

class PilotDetailsActivity : AppCompatActivity() {

    lateinit var viewModel: PilotDetailsViewModel
    lateinit var binding: ActivityPilotDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = withViewModel({ PilotDetailsViewModel(application) }) {
            /*observe(responseData) {
                setRecyclerView()
            }*/
        }
            val minha = intent.extras?.getParcelable<PilotData>("PILOT")
        binding = bindingContentView(R.layout.activity_pilot_details).also {
            it.setVariable(BR.viewModel, viewModel)
            it.setVariable(BR.title, minha?.pilot?.name)
        } as ActivityPilotDetailsBinding
        setSupportActionBar(toolbar)
    }
}
