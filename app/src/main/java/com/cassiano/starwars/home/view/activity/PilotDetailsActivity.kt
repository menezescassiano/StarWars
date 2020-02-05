package com.cassiano.starwars.home.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
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
        val pilot = intent.extras?.getParcelable<PilotData>(BUNDLE_PILOT)
        val pilotRating = pilot?.pilot?.rating

        binding = bindingContentView(R.layout.activity_pilot_details).apply {
            setVariable(BR.viewModel, viewModel)
            setVariable(BR.onBackClick, View.OnClickListener { finish() })
            setVariable(BR.drawable, pilot?.pilot?.name?.let { name -> DrawableUtils.getAvatar(activity, name) })
            setVariable(BR.pickUpDrawable, pilot?.pickUp?.name?.let { it1 -> DrawableUtils.getPlanet(activity, it1) })
            setVariable(BR.dropOffDrawable, pilot?.dropOff?.name?.let { it1 -> DrawableUtils.getPlanet(activity, it1) })
            setVariable(BR.title, pilot?.pilot?.name)
            setVariable(BR.pickUp, pilot?.pickUp?.name)
            setVariable(
                BR.pickUp,
                pilot?.pickUp?.date?.let { date -> StringFormatUtils.getTime(date) })
            setVariable(
                BR.dropOff,
                pilot?.dropOff?.date?.let { date -> StringFormatUtils.getTime(date) })
            setVariable(
                BR.distance,
                pilot?.distance?.value?.let { distance -> getString(R.string.km_text, StringFormatUtils.getDistanceFormated(distance)) })
            setVariable(BR.duration, pilot?.duration?.let { duration -> StringFormatUtils.getHourMinSecFormat(activity, duration) })
            setVariable(BR.textVisibility, pilotRating?.let { rating -> setRatingTextVisibility(rating) })

            setVariable(BR.star1, pilotRating?.let { rating -> DrawableUtils.getStarRating(activity, 1, rating) })
            setVariable(BR.star2, pilotRating?.let { rating -> DrawableUtils.getStarRating(activity, 2, rating) })
            setVariable(BR.star3, pilotRating?.let { rating -> DrawableUtils.getStarRating(activity, 3, rating) })
            setVariable(BR.star4, pilotRating?.let { rating -> DrawableUtils.getStarRating(activity, 4, rating) })
            setVariable(BR.star5, pilotRating?.let { rating -> DrawableUtils.getStarRating(activity, 5, rating) })
        } as ActivityPilotDetailsBinding
    }

    private fun setRatingTextVisibility(rating: Float): Int {
        if (rating > 0.0) {
            return View.GONE
        }

        return View.VISIBLE
    }

}