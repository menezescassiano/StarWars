package com.cassiano.starwars.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.extension.withViewModel
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.utils.DateFormatUtils
import com.cassiano.starwars.viewmodel.PilotDetailsViewModel
import kotlinx.android.synthetic.main.activity_pilot_details.*


class PilotDetailsActivity : AppCompatActivity() {

    lateinit var viewModel: PilotDetailsViewModel
    lateinit var binding: ActivityPilotDetailsBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = withViewModel({ PilotDetailsViewModel(application) }) {
            /*observe(responseData) {
                setRecyclerView()
            }*/
        }
        val pilot = intent.extras?.getParcelable<PilotData>("PILOT")

        binding = bindingContentView(R.layout.activity_pilot_details).also {
            it.setVariable(BR.viewModel, viewModel)
            it.setVariable(BR.title, pilot?.pilot?.name)
            it.setVariable(BR.pickUp, pilot?.pickUp?.name)
            it.setVariable(
                BR.pickUp,
                pilot?.pickUp?.date?.let { date -> DateFormatUtils.getTime(date) })
            it.setVariable(
                BR.dropOff,
                pilot?.dropOff?.date?.let { date -> DateFormatUtils.getTime(date) })
        } as ActivityPilotDetailsBinding

        setSupportActionBar(toolbar)
    }

}