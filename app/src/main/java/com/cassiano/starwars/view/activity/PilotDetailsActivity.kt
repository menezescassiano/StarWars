package com.cassiano.starwars.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.ActivityPilotDetailsBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.utils.DateFormatUtils
import com.cassiano.starwars.utils.DrawableUtils
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
        val pilot = intent.extras?.getParcelable<PilotData>(BUNDLE_PILOT)

        binding = bindingContentView(R.layout.activity_pilot_details).also {
            it.setVariable(BR.viewModel, viewModel)
            it.setVariable(BR.onBackClick, View.OnClickListener { finish() })
            it.setVariable(BR.title, pilot?.pilot?.name)
            it.setVariable(BR.pickUp, pilot?.pickUp?.name)
            it.setVariable(
                BR.pickUp,
                pilot?.pickUp?.date?.let { date -> DateFormatUtils.getTime(date) })
            it.setVariable(
                BR.dropOff,
                pilot?.dropOff?.date?.let { date -> DateFormatUtils.getTime(date) })
            it.setVariable(BR.distance, "2,478,572 KM")
            it.setVariable(BR.duration, "5:23:47")
            it.setVariable(BR.star1, pilot?.pilot?.rating?.let { rating -> getStar(this, 1, rating) })
            it.setVariable(BR.star2, pilot?.pilot?.rating?.let { rating -> getStar(this, 2, rating) })
            it.setVariable(BR.star3, pilot?.pilot?.rating?.let { rating -> getStar(this, 3, rating) })
            it.setVariable(BR.star4, pilot?.pilot?.rating?.let { rating -> getStar(this, 4, rating) })
            it.setVariable(BR.star5, pilot?.pilot?.rating?.let { rating -> getStar(this, 5, rating) })
            it.setVariable(BR.textVisibility, pilot?.pilot?.rating?.let { rating -> setRatingTextVisibility(rating) })
        } as ActivityPilotDetailsBinding
        setSupportActionBar(toolbar)
    }

    private fun getStar(context: Context, index: Int, count: Float): Drawable? {
        if (count == 0.0f) {
            return null
        } else if (index <= count) {
            return DrawableUtils.getDrawable(context, R.drawable.filled_star)
        }
        return DrawableUtils.getDrawable(context, R.drawable.empty_star)
    }

    private fun setRatingTextVisibility(rating: Float): Int {
        if (rating > 0.0) { return View.GONE }

        return View.VISIBLE
    }

}