package com.cassiano.starwars.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.utils.DrawableUtils
import com.cassiano.starwars.utils.StringFormatUtils
import com.cassiano.starwars.view.activity.MainActivity.Companion.BUNDLE_PILOT
import com.cassiano.starwars.viewmodel.PilotDetailsViewModel
import kotlinx.android.synthetic.main.activity_pilot_details.*


class PilotDetailsActivity : AppCompatActivity() {

    lateinit var viewModel: PilotDetailsViewModel
    lateinit var binding: ActivityPilotDetailsBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = PilotDetailsViewModel(application)
        setBinding()

        setSupportActionBar(toolbar)
    }

    private fun setBinding() {
        val pilot = intent.extras?.getParcelable<PilotData>(BUNDLE_PILOT)
        val pilotRating = pilot?.pilot?.rating

        binding = bindingContentView(R.layout.activity_pilot_details).also {
            it.setVariable(BR.viewModel, viewModel)
            it.setVariable(BR.onBackClick, View.OnClickListener { finish() })
            it.setVariable(BR.pickUpDrawable, pilot?.pickUp?.name?.let { it1 -> DrawableUtils.getPlanet(this, it1) })
            it.setVariable(BR.dropOffDrawable, pilot?.dropOff?.name?.let { it1 -> DrawableUtils.getPlanet(this, it1) })
            it.setVariable(BR.title, pilot?.pilot?.name)
            it.setVariable(BR.pickUp, pilot?.pickUp?.name)
            it.setVariable(
                BR.pickUp,
                pilot?.pickUp?.date?.let { date -> StringFormatUtils.getTime(date) })
            it.setVariable(
                BR.dropOff,
                pilot?.dropOff?.date?.let { date -> StringFormatUtils.getTime(date) })
            it.setVariable(
                BR.distance,
                pilot?.distance?.value?.let { distance -> getString(R.string.km_text, StringFormatUtils.getDistanceFormated(distance)) })
            it.setVariable(BR.duration, pilot?.duration?.let { duration -> getTimeInH(duration) })
            it.setVariable(BR.textVisibility, pilotRating?.let { rating -> setRatingTextVisibility(rating) })

            it.setVariable(BR.star1, pilotRating?.let { rating -> DrawableUtils.getStarRating(this, 1, rating) })
            it.setVariable(BR.star2, pilotRating?.let { rating -> DrawableUtils.getStarRating(this, 2, rating) })
            it.setVariable(BR.star3, pilotRating?.let { rating -> DrawableUtils.getStarRating(this, 3, rating) })
            it.setVariable(BR.star4, pilotRating?.let { rating -> DrawableUtils.getStarRating(this, 4, rating) })
            it.setVariable(BR.star5, pilotRating?.let { rating -> DrawableUtils.getStarRating(this, 5, rating) })
        } as ActivityPilotDetailsBinding
    }

    private fun getTimeInH(seconds: Int): String {
        val hours: Int = seconds / 60 / 60//since both are ints, you get an int

        val minutes: Int = seconds % 60
        return getString(R.string.hh_min, hours, minutes)
    }

    private fun setRatingTextVisibility(rating: Float): Int {
        if (rating > 0.0) {
            return View.GONE
        }

        return View.VISIBLE
    }

}