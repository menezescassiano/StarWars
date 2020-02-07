package com.cassiano.starwars.home.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.home.adapter.RatingListAdapter
import com.cassiano.starwars.home.model.Pilot
import com.cassiano.starwars.home.model.PilotData
import com.cassiano.starwars.home.view.activity.MainActivity.Companion.BUNDLE_PILOT
import com.cassiano.starwars.home.viewmodel.PilotDetailsViewModel
import com.cassiano.starwars.utils.DrawableUtils
import com.cassiano.starwars.utils.StringFormatUtils
import kotlinx.android.synthetic.main.activity_pilot_details.*


class PilotDetailsActivity : AppCompatActivity() {

    lateinit var viewModel: PilotDetailsViewModel
    lateinit var binding: ActivityPilotDetailsBinding
    private val activity = this@PilotDetailsActivity

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = PilotDetailsViewModel(application)
        setBinding()

        setSupportActionBar(toolbar)
    }

    private fun setBinding() {
        val pilotData = intent.extras?.getParcelable<PilotData>(BUNDLE_PILOT)
        val pilotRating = pilotData?.pilot?.rating

        binding = bindingContentView(R.layout.activity_pilot_details).apply {
            setVariable(BR.viewModel, viewModel)
            setVariable(BR.onBackClick, View.OnClickListener { finish() })
            setVariable(BR.drawable, pilotData?.pilot?.name?.let { name -> DrawableUtils.getAvatar(activity, name) })
            setVariable(BR.pickUpDrawable, pilotData?.pickUp?.name?.let { it1 -> DrawableUtils.getPlanet(activity, it1) })
            setVariable(BR.dropOffDrawable, pilotData?.dropOff?.name?.let { it1 -> DrawableUtils.getPlanet(activity, it1) })
            setVariable(BR.title, pilotData?.pilot?.name)
            setVariable(BR.pickUp, pilotData?.pickUp?.name)
            setVariable(
                BR.timeDeparture,
                pilotData?.pickUp?.date?.let { date -> StringFormatUtils.getTime(date) })
            setVariable(BR.dropOff, pilotData?.dropOff?.name)
            setVariable(
                BR.timeArrival,
                pilotData?.dropOff?.date?.let { date -> StringFormatUtils.getTime(date) })
            setVariable(
                BR.distance,
                pilotData?.distance?.value?.let { distance -> getString(R.string.km_text, StringFormatUtils.getDistanceFormated(distance)) })
            setVariable(BR.duration, pilotData?.duration?.let { duration -> StringFormatUtils.getHourMinSecFormat(duration) })
            setVariable(BR.textVisibility, pilotRating?.let { rating -> setRatingTextVisibility(rating) })

        } as ActivityPilotDetailsBinding

        pilotData?.pilot?.let {
            if (it.rating > 0.0) {
                setRecyclerView(it)
            }
        }
    }

    private fun setRecyclerView(pilot: Pilot) {
        val listAdapter = RatingListAdapter(pilot.getRatingList())
        binding.pilotLayout.pilotRatingLayout.ratingRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setRatingTextVisibility(rating: Float): Int {
        if (rating > 0.0) {
            return View.GONE
        }

        return View.VISIBLE
    }

}