package com.cassiano.starwars.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.model.PilotData
import com.cassiano.starwars.utils.DrawableUtils

class PilotViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PilotData) {

        binding.apply {
            val context = this.root.context

            item.run {
                setVariable(BR.name, pilot?.name)
                setVariable(BR.pickUp, pickUp?.name)
                setVariable(BR.dropOff, dropOff?.name)
                setVariable(BR.rating, pilot?.rating.toString())
                setVariable(BR.picture, pilot?.name?.let { DrawableUtils.getAvatar(context, it) })
                setVariable(BR.star1, pilot?.rating?.let { getStar(context, 1, it) })
                setVariable(BR.star2, pilot?.rating?.let { getStar(context, 2, it) })
                setVariable(BR.star3, pilot?.rating?.let { getStar(context, 3, it) })
                setVariable(BR.star4, pilot?.rating?.let { getStar(context, 4, it) })
                setVariable(BR.star5, pilot?.rating?.let { getStar(context, 5, it) })
            }
            executePendingBindings()
        }
    }

    private fun getStar(context: Context, index: Int, count: Float): Drawable? {
        if (count == 0.0f) {
            return null
        } else if (index <= count) {
            return DrawableUtils.getDrawable(context, R.drawable.filled_star)
        }
        return DrawableUtils.getDrawable(context, R.drawable.empty_star)
    }

}